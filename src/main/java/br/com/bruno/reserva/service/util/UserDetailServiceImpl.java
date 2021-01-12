package br.com.bruno.reserva.service.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.bruno.reserva.model.Usuario;
import br.com.bruno.reserva.repository.UsuarioRepository;
import br.com.bruno.reserva.security.UserDetailsImpl;
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.buscarPorCpf(cpf);
		
		return new UserDetailsImpl(usuario.orElseThrow(() -> new UsernameNotFoundException(cpf)));
	}

}
