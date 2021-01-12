package br.com.bruno.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.reserva.model.Passagem;
import br.com.bruno.reserva.repository.customizer.PassagemRepositoryCustomizer;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long>, PassagemRepositoryCustomizer{

}
