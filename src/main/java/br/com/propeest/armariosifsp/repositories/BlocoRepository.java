package br.com.propeest.armariosifsp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.propeest.armariosifsp.models.Bloco;
import br.com.propeest.armariosifsp.models.EntidadeEstudantil;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long>{

	List<Bloco> findByEntidadeEstudantil(EntidadeEstudantil entidadeEstudantil);
	Optional<Bloco> findByNome(String nome);
	Optional<Bloco> findByNomeIgnoreCase(String nome);
}
