package br.com.bruno.reserva.repository.implemen;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.bruno.reserva.repository.customizer.OnibusRepositoryCustomizer;

public class OnibusRepositoryImpl implements OnibusRepositoryCustomizer {

	@PersistenceContext
	private EntityManager entityManager;

	
}
