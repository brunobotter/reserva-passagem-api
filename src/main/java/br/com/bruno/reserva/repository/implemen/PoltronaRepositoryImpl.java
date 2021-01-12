package br.com.bruno.reserva.repository.implemen;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.bruno.reserva.exception.ObjetoNaoEncontradoException;
import br.com.bruno.reserva.model.Poltrona;
import br.com.bruno.reserva.repository.customizer.PoltronaRepositoryCustomizer;

public class PoltronaRepositoryImpl implements PoltronaRepositoryCustomizer {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Poltrona findPoltronas(int numeroPoltrona, Long onibusId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Poltrona> cq = cb.createQuery(Poltrona.class);

		Root<Poltrona> root = cq.from(Poltrona.class);
		CriteriaQuery<Poltrona> query = cq.select(root);

		Predicate predicadoPoltrona = cb.equal(root.get("numeroPoltrona"), numeroPoltrona);
		Predicate predicadoOnibus = cb.equal(root.get("onibus").get("onibusId"), onibusId);
		Predicate[] predicates = { predicadoOnibus, predicadoPoltrona };

		query.where(predicates);

		TypedQuery<Poltrona> tq = entityManager.createQuery(query);

		try {
			return tq.getSingleResult();
		} catch (NoResultException e) {
			throw new ObjetoNaoEncontradoException("Poltrona nao encontrada!");
		}
	}

	
	@Override
	public Poltrona findPoltronasCancelada(int numeroPoltrona, Long onibusId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Poltrona> cq = cb.createQuery(Poltrona.class);

		Root<Poltrona> root = cq.from(Poltrona.class);
		CriteriaQuery<Poltrona> query = cq.select(root);

		Predicate predicadoPoltrona = cb.equal(root.get("numeroPoltrona"), numeroPoltrona);
		Predicate predicadoOnibus = cb.equal(root.get("onibus").get("onibusId"), onibusId);
		Predicate[] predicates = { predicadoOnibus, predicadoPoltrona };

		query.where(predicates);

		TypedQuery<Poltrona> tq = entityManager.createQuery(query);

		try {
			return tq.getSingleResult();
		} catch (NoResultException e) {
			throw new ObjetoNaoEncontradoException("Poltrona nao encontrada!");
		}
	}

	
}
