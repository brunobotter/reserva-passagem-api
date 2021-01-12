package br.com.bruno.reserva.repository.implemen;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.bruno.reserva.model.Cidades;
import br.com.bruno.reserva.repository.customizer.CidadeRepositoryCustomizer;

public class CidadeRepositoryImpl implements CidadeRepositoryCustomizer {

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Optional<Cidades> nomeCidade(String nomeCidade) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cidades> cq = cb.createQuery(Cidades.class);

		Root<Cidades> root = cq.from(Cidades.class);
		CriteriaQuery<Cidades> query = cq.select(root);

		Predicate predicado = cb.equal(root.get("nomeCidade"), nomeCidade);

		Predicate[] predicates = { predicado };

		query.where(predicates);

		TypedQuery<Cidades> tq = entityManager.createQuery(query);

		try {
			return Optional.of(tq.getSingleResult());
		} catch (NoResultException e) {
			return null;
		}
	}
}
