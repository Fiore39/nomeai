package br.com.propeest.armariosifsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.propeest.armariosifsp.models.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{

}
