package br.com.bruno.reserva.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.reserva.dto.request.NovaPassagemDto;
import br.com.bruno.reserva.dto.response.ExibirPassagemDto;
import br.com.bruno.reserva.model.Passagem;
import br.com.bruno.reserva.service.PassagemService;
import br.com.bruno.reserva.service.util.EnvioEmail;

@RestController
@RequestMapping("api/passagem")
public class PassagemController {
	@Autowired
	private PassagemService passagemService;
	
	@Autowired
	private EnvioEmail envioEmail;

	@GetMapping("{id}")
	public ResponseEntity<ExibirPassagemDto> buscaPorId(@PathVariable Long id) {
		Passagem passagem = passagemService.buscar(id);
		return new ResponseEntity<ExibirPassagemDto>(new ExibirPassagemDto(passagem), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<ExibirPassagemDto>> buscaTodos() {
		List<Passagem> passagem = passagemService.listarTodos();
		List<ExibirPassagemDto> dto = passagem.stream().map(p -> new ExibirPassagemDto(p)).collect(Collectors.toList());
		return ResponseEntity.ok(dto);
	}

	@PreAuthorize("hasRole('CLIENTE')")
	@PostMapping()
	public ResponseEntity<ExibirPassagemDto> adicionar(@Valid @RequestBody NovaPassagemDto dto) {
		Passagem passagem = passagemService.converteNovaPassagemDtoEmEntidade(dto);
		passagem = passagemService.salvar(passagem);
		envioEmail.enviar(passagem.getUsuario().getEmail(), "Passagem reservada com sucesso!", "");
		return new ResponseEntity<ExibirPassagemDto>(new ExibirPassagemDto(passagem), HttpStatus.CREATED);
	}

}
