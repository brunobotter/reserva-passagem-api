package br.com.bruno.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.reserva.model.Poltrona;
import br.com.bruno.reserva.repository.customizer.PoltronaRepositoryCustomizer;

@Repository
public interface PoltronaRepository extends JpaRepository<Poltrona, Long>, PoltronaRepositoryCustomizer{

	//@Query("select p from Poltrona p where p.numeroPoltrona = ?1 and p.onibus.onibusId = ?2")
	//Poltrona findPoltronas(int numeroPoltrona, Long onibusId);
	
}
