package br.com.propeest.armariosifsp.repositories;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.propeest.armariosifsp.models.Contrato;
import br.com.propeest.armariosifsp.models.StatusArmario;

public interface ContratoRepository extends JpaRepository<Contrato, Long>{

	@Query("SELECT c FROM Contrato c INNER JOIN c.aluno a INNER JOIN c.armario d WHERE a.email = :email AND d.nome LIKE :nomeArmario AND d.status = :status AND c.dataVencimento <= :data")
	List<Contrato> buscaPorAdmNull(String email, String nomeArmario, StatusArmario status, OffsetDateTime data);
	
	@Query("SELECT c FROM Contrato c INNER JOIN c.armario arm WHERE arm.status = :status")
	List<Contrato> findByStatusArmario(StatusArmario status);
	
	@Query("SELECT c FROM Contrato c INNER JOIN c.armario arm INNER JOIN c.aluno alu WHERE arm.status = :status AND alu.nome LIKE %:nome%")
	List<Contrato> findByStatusArmarioAndNome(StatusArmario status, String nome);
}
/*
 * 
 * nativeQuery = true,
			value = "SELECT * FROM Contrato con INNER JOIN Armario arm ON (arm.id = con.armario_id) WHERE arm.status = :status"
 * 
 */