package br.com.bruno.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.reserva.model.Onibus;
import br.com.bruno.reserva.repository.customizer.OnibusRepositoryCustomizer;

@Repository
public interface OnibusRepository extends JpaRepository<Onibus, Long>, OnibusRepositoryCustomizer{

}
