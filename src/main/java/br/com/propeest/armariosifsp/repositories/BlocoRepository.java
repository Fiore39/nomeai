package br.com.propeest.armariosifsp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.propeest.armariosifsp.models.Bloco;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long>{

	List<Bloco> findByEntidadeEstudantil(String entidadeEstudantil);
}
