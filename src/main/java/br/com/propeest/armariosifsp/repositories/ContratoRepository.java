package br.com.propeest.armariosifsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.propeest.armariosifsp.models.Contrato;
import br.com.propeest.armariosifsp.models.Armario;

public interface ContratoRepository extends JpaRepository<Contrato, Long>{

	Contrato findByArmario(Armario armario);
}
