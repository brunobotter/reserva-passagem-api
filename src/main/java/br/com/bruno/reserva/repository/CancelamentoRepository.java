package br.com.bruno.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.reserva.model.Cancelamento;
import br.com.bruno.reserva.repository.customizer.CancelamentoRepositoryCustomizer;

@Repository
public interface CancelamentoRepository extends JpaRepository<Cancelamento, Long>, CancelamentoRepositoryCustomizer{

}
