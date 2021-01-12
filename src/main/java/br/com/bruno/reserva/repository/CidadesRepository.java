package br.com.bruno.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.reserva.model.Cidades;
import br.com.bruno.reserva.repository.customizer.CidadeRepositoryCustomizer;

@Repository
public interface CidadesRepository extends JpaRepository<Cidades, Long>, CidadeRepositoryCustomizer {

}
