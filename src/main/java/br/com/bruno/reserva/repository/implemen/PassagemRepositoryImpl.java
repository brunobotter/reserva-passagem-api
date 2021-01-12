package br.com.bruno.reserva.repository.implemen;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.bruno.reserva.repository.customizer.PassagemRepositoryCustomizer;

public class PassagemRepositoryImpl implements PassagemRepositoryCustomizer {

	@PersistenceContext
	private EntityManager entityManager;


}
