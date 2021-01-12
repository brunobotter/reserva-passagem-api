package br.com.bruno.reserva.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.reserva.dto.request.NovoClienteDto;
import br.com.bruno.reserva.dto.request.NovoFuncionarioDto;
import br.com.bruno.reserva.dto.request.UsuarioDto;
import br.com.bruno.reserva.dto.response.ExibirClienteDto;
import br.com.bruno.reserva.dto.response.ExibirFuncionarioDto;
import br.com.bruno.reserva.model.Usuario;
import br.com.bruno.reserva.service.UsuarioService;
import br.com.bruno.reserva.service.util.EnvioEmail;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EnvioEmail envioEmail;

	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@GetMapping("{id}")
	public ResponseEntity<ExibirClienteDto> buscaPorId(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscar(id);
		return ResponseEntity.ok(new ExibirClienteDto(usuario));
	}

	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<ExibirClienteDto>> buscaTodos() {
		List<Usuario> usuario = usuarioService.listarTodos();
		List<ExibirClienteDto> usuarioDto = usuario.stream().map(u -> new ExibirClienteDto(u))
				.collect(Collectors.toList());
		return ResponseEntity.ok(usuarioDto);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		usuarioService.remover(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/adicionar_cliente")
	public ResponseEntity<ExibirClienteDto> adicionarCliente(@Valid @RequestBody NovoClienteDto novoCliente) {
		Usuario cliente = usuarioService.converteNovoClienteDTOEmEntidade(novoCliente);
		cliente = usuarioService.salvarCliente(cliente);
		envioEmail.enviar(cliente.getEmail(), "Bem vindo!", "Usuario criado com sucesso! \nUser seu CPF e senha para realizar o login!");
		return new ResponseEntity<ExibirClienteDto>(new ExibirClienteDto(cliente), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("adicionar_funcionario")
	public ResponseEntity<ExibirFuncionarioDto> adicionarFuncionario(
			@Valid @RequestBody NovoFuncionarioDto novoFuncionario) {
		Usuario funcionario = usuarioService.converteNovoFuncionarioDTOEmEntidade(novoFuncionario);
		funcionario = usuarioService.salvarFuncionario(funcionario);
		return new ResponseEntity<ExibirFuncionarioDto>(new ExibirFuncionarioDto(funcionario), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('CLIENTE') or hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<ExibirClienteDto> atualizar(@Valid @RequestBody UsuarioDto usuarioDto, @PathVariable Long id) {
		Usuario usuario = usuarioService.converteUsuarioDTOEmEntidade(usuarioDto);
		usuario.setUsuarioId(id);
		usuario = usuarioService.atualizar(usuario, id);
		return new ResponseEntity<ExibirClienteDto>(new ExibirClienteDto(usuario), HttpStatus.OK);
	}
}
