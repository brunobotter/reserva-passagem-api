package br.com.bruno.reserva.repository.customizer;

import java.util.Optional;

import br.com.bruno.reserva.model.Cidades;

public interface CidadeRepositoryCustomizer {

	Optional<Cidades> nomeCidade(String nomeCidade);

}
