package br.com.propeest.armariosifsp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.propeest.armariosifsp.models.Contrato;
import br.com.propeest.armariosifsp.models.Armario;

public interface ContratoRepository extends JpaRepository<Contrato, Long>{

	Optional<Contrato> findByArmario(Armario armario);
}
