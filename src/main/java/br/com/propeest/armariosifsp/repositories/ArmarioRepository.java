package br.com.propeest.armariosifsp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Bloco;

@Repository
public interface ArmarioRepository extends JpaRepository<Armario, Long>{

	List<Armario> findByBloco(Bloco bloco);
	Optional<Armario> findByNome(String nome);
	Optional<Armario> findByIdAndNome(Long id, String nome);
}
