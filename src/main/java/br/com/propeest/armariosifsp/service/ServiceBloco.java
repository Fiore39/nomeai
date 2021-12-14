package br.com.propeest.armariosifsp.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.propeest.armariosifsp.InputModels.ArmarioOutput;
import br.com.propeest.armariosifsp.InputModels.BlocoInput;
import br.com.propeest.armariosifsp.InputModels.BlocoOutput;
import br.com.propeest.armariosifsp.assembler.ArmarioAssembler;
import br.com.propeest.armariosifsp.assembler.BlocoAssembler;
import br.com.propeest.armariosifsp.exceptions.NegocioException;
import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Bloco;
import br.com.propeest.armariosifsp.models.EntidadeEstudantil;
import br.com.propeest.armariosifsp.models.Local;
import br.com.propeest.armariosifsp.repositories.BlocoRepository;
import br.com.propeest.armariosifsp.repositories.LocalRepository;

@Service
public class ServiceBloco {
	
	private BlocoRepository blocoRepository;
	private LocalRepository localRepository;
	private ServiceArmario serviceArmario;
	private BlocoAssembler blocoAssembler;
	private ArmarioAssembler armarioAssembler;
	
	public ServiceBloco(BlocoRepository blocoRepository, LocalRepository localRepository, ServiceArmario serviceArmario,
			BlocoAssembler blocoAssembler, ArmarioAssembler armarioAssembler) {
		super();
		this.blocoRepository = blocoRepository;
		this.localRepository = localRepository;
		this.serviceArmario = serviceArmario;
		this.blocoAssembler = blocoAssembler;
		this.armarioAssembler = armarioAssembler;
	}
	
	public List<BlocoOutput> listByEntidadeEstudantil(String entidadeEstudantil){
		return blocoAssembler.toCollectionModel(
				blocoRepository.findByEntidadeEstudantil(
						EntidadeEstudantil.fromString(entidadeEstudantil)
					)
				);
	}

	@Transactional
	public List<ArmarioOutput> adicionar(BlocoInput blocoInput) {
		List<Armario> armarios = new ArrayList<Armario>();
		Bloco bloco = blocoAssembler.toBloco(blocoInput);
		Optional<Local> optionalLocal = localRepository.findById(blocoInput.getLocal().getId());
		
		if(optionalLocal.isPresent()) {
			Local local = optionalLocal.get();
			bloco.setLocal(local);
		} else {
			throw new NegocioException("Local não encontrado!");
		}
		
		checkBlocoExists(bloco);
		
		bloco = blocoRepository.save(bloco);
		for (int i = 0; i < 16; i++) {
            armarios.add(serviceArmario.salvar(bloco, i + 1));
        }
		return armarioAssembler.toCollectionModel(armarios);
	}
	
	@Transactional
	public void excluir(Long idbloco) {
		blocoRepository.deleteById(idbloco);
	}
	
	public Bloco buscar(String entidadeEstudantil, String nomeBloco) {
		Optional<Bloco> bloco = findEntidadeEstudantilAndNome(entidadeEstudantil, nomeBloco);
		
		if (bloco.isEmpty()) {
			String nome = getNomeListBlocos(blocoRepository.findByEntidadeEstudantil(EntidadeEstudantil.fromString(entidadeEstudantil)), nomeBloco);
			
			if (nome != "") {
				nomeBloco = nome;
			}
			
			bloco = findEntidadeEstudantilAndNome(entidadeEstudantil, nomeBloco);
			if (bloco.isEmpty()) {
				throw new NegocioException(
						"Não existe bloco de nome <" + nomeBloco +
						"> para a Entidade Estudantil <" + EntidadeEstudantil.fromString(entidadeEstudantil).getValor() + ">"
				);
			} else {
				return bloco.get();
			}
		}
		
		return bloco.get();
	}
	
	public void checkEntidadeAndBloco(String entidadeEstudantil, String nomeBloco) {
		Optional<Bloco> bloco = findEntidadeEstudantilAndNome(entidadeEstudantil, nomeBloco);
		
		if (bloco.isEmpty()) {
			
			if(!checkNomeListBlocos(
					blocoRepository.findByEntidadeEstudantil(EntidadeEstudantil.fromString(entidadeEstudantil)),
					nomeBloco))
			{
				throw new NegocioException(
						"Não existe bloco de nome <" + nomeBloco +
						"> para a Entidade Estudantil <" + EntidadeEstudantil.fromString(entidadeEstudantil).getValor() + ">"
						);
			}
		}
	}
	
	public Optional<Bloco> findEntidadeEstudantilAndNome(String entidadeEstudantil, String nomeBloco) {
		Optional<Bloco> bloco = blocoRepository.findByNomeAndEntidadeEstudantil(EntidadeEstudantil.fromString(entidadeEstudantil), nomeBloco);
		return bloco;
	}
	
	public void checkBlocoExists(Bloco bloco) {
		if(checkNomeListBlocos(blocoRepository.findAll(), bloco.getNome())) {
			throw new NegocioException("Já existe outro bloco com mesmo nome!");
		}
	}
	
	public String getNomeListBlocos(List<Bloco> blocos, String str) {
		for(Bloco blocoCheck : blocos) {
			if(matchWords(str, blocoCheck.getNome())) {
				return blocoCheck.getNome();
			}
		}
		return "";
	}
	
	public Boolean checkNomeListBlocos(List<Bloco> blocos, String str) {
		for(Bloco blocoCheck : blocos) {
			if(matchWords(str, blocoCheck.getNome())) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean matchWords(String a, String b) {
		a = removerAcentos(a.toUpperCase());
		b = removerAcentos(b.toUpperCase());
		if(a.matches(b)) {
			return true;
		} else
			return false;
	}
	
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

}
