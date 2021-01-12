package br.com.bruno.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.reserva.model.Usuario;
import br.com.bruno.reserva.repository.customizer.UsuarioRepositoryCustomizer;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryCustomizer {


}
