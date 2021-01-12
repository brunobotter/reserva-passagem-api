package br.com.bruno.reserva.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.bruno.reserva.dto.request.NovoClienteDto;
import br.com.bruno.reserva.dto.request.NovoFuncionarioDto;
import br.com.bruno.reserva.dto.request.UsuarioDto;
import br.com.bruno.reserva.exception.AuthorizationException;
import br.com.bruno.reserva.exception.NegocioException;
import br.com.bruno.reserva.model.Passagem;
import br.com.bruno.reserva.model.Usuario;
import br.com.bruno.reserva.model.enuns.Role;
import br.com.bruno.reserva.repository.UsuarioRepository;
import br.com.bruno.reserva.security.UserDetailsImpl;
import br.com.bruno.reserva.service.util.ServiceGenericoImpl;

@Service
public class UsuarioService extends ServiceGenericoImpl<Usuario, Long> {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;



	public UsuarioService(JpaRepository<Usuario, Long> jpaRepository, UsuarioRepository usuarioRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super(jpaRepository);
		this.usuarioRepository = usuarioRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public Usuario converteNovoClienteDTOEmEntidade(NovoClienteDto dto) {
		Usuario cliente = new Usuario();
		cliente.setCpf(dto.getCpf());
		cliente.setDataNascimento(dto.getDataNascimento());
		cliente.setEmail(dto.getEmail());
		cliente.setNome(dto.getNome());
		cliente.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));
		cliente.addPerfil(Role.CLIENTE);
		return cliente;
		
	}

	public Usuario converteNovoFuncionarioDTOEmEntidade(NovoFuncionarioDto dto) {
		Usuario funcionario = new Usuario();
		funcionario.setCpf(dto.getCpf());
		funcionario.setDataNascimento(dto.getDataNascimento());
		funcionario.setEmail(dto.getEmail());
		funcionario.setNome(dto.getNome());
		funcionario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));
		funcionario.addPerfil(Role.FUNCIONARIO);
		return funcionario;
	}

	public Usuario converteUsuarioDTOEmEntidade(UsuarioDto usuarioDto) {
		return new Usuario(usuarioDto);
	}

	public UserDetailsImpl getUserDetails() {
		try {
			return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

	public boolean hasRole(Role perfil) {
		UserDetailsImpl user = getUserDetails();

		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		return user.hasRole(perfil);
	}

	@Override
	public Usuario buscar(Long key) {
		return super.buscar(key);
	}

	@Override
	public Usuario atualizar(Usuario entity, Long key) {
		Usuario usuario = buscar(key);
		if (!usuario.getCpf().equalsIgnoreCase(entity.getCpf())) {
			verificaCpf(entity.getCpf());
			usuario.setCpf(entity.getCpf());
		}
		if (!usuario.getEmail().equalsIgnoreCase(entity.getEmail())) {
			verificaEmail(entity.getEmail());
			usuario.setEmail(entity.getEmail());
		}
		if(entity.getSenha() != null) {
			usuario.setSenha(bCryptPasswordEncoder.encode(entity.getSenha()));
		}
		usuario.setSenha(usuario.getSenha());
		
		usuario.setDataNascimento(entity.getDataNascimento());
		usuario.setNome(entity.getNome());
		return super.atualizar(usuario, key);
	}

	public Usuario salvarFuncionario(Usuario entity) {
		verificaCpfEmail(entity.getCpf(), entity.getEmail());
		entity.addPerfil(Role.FUNCIONARIO);
		return super.salvar(entity);
	}

	public Usuario salvarCliente(Usuario entity) {
		verificaCpfEmail(entity.getCpf(), entity.getEmail());
		entity.addPerfil(Role.CLIENTE);
		return super.salvar(entity);
	}

	@Override
	public void remover(Long key) {
		Usuario usuario = buscar(key);
		super.remover(usuario.getUsuarioId());
	}

	public boolean verificaCpfEmail(String cpf, String email) {
		Optional<Usuario> usuarioEmail = usuarioRepository.buscaPorEmail(email);
		if (usuarioEmail.isEmpty()) {
			Optional<Usuario> usuarioCpf = usuarioRepository.buscarPorCpf(cpf);
			if (usuarioCpf.isEmpty()) {
				return true;
			} else {
				throw new NegocioException("CPF já cadastrado no sistema!");
			}
		} else {
			throw new NegocioException("Email já cadastrado no sistema!");
		}
	}

	public boolean verificaCpf(String cpf) {
		Optional<Usuario> usuarioCpf = usuarioRepository.buscarPorCpf(cpf);
		if (usuarioCpf.isEmpty()) {
			return true;
		} else {
			throw new NegocioException("CPF já cadastrado no sistema!");
		}
	}

	public boolean verificaEmail(String email) {
		Optional<Usuario> usuarioEmail = usuarioRepository.buscaPorEmail(email);
		if (usuarioEmail.isEmpty()) {
			return true;
		} else {
			throw new NegocioException("Email já cadastrado no sistema!");
		}
	}

	public boolean validaClienteCancelamento(Passagem passagem) {
		UserDetailsImpl user = getUserDetails();
		
		if (user == null || !user.hasRole(Role.CLIENTE) || !passagem.getUsuario().getCpf().equals(user.getCliente().getCpf())) {
			throw new AuthorizationException("Acesso negado");
		}
		return true;
	}
	

}
