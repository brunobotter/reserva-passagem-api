package br.com.bruno.reserva.repository.implemen;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.bruno.reserva.repository.customizer.CancelamentoRepositoryCustomizer;

public class CancelamentoRepositoryImpl implements CancelamentoRepositoryCustomizer {

	@PersistenceContext
	private EntityManager entityManager;


	
}
