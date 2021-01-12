package br.com.bruno.reserva.repository.customizer;

import java.util.Optional;

import br.com.bruno.reserva.model.Usuario;

public interface UsuarioRepositoryCustomizer {

	public Optional<Usuario> buscarPorCpf(String cpf);
	public Optional<Usuario> buscaPorEmail(String email);
}
