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

import br.com.bruno.reserva.dto.request.NovoCancelamentoDto;
import br.com.bruno.reserva.dto.response.ExibirCancelamentoDto;
import br.com.bruno.reserva.model.Cancelamento;
import br.com.bruno.reserva.service.CancelamentoService;
import br.com.bruno.reserva.service.util.EnvioEmail;

@RestController
@RequestMapping("api/cancelamento")
public class CancelamentoController {
	@Autowired
	private CancelamentoService cancelamentoService;
	
	@Autowired
	private EnvioEmail envioEmail;

	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@GetMapping("{id}")
	public ResponseEntity<ExibirCancelamentoDto> buscaPorId(@PathVariable Long id) {
		Cancelamento cancelamento = cancelamentoService.buscar(id);
		return new ResponseEntity<ExibirCancelamentoDto>(new ExibirCancelamentoDto(cancelamento), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<ExibirCancelamentoDto>> buscaTodos() {
		List<Cancelamento> cancelamento = cancelamentoService.listarTodos();
		List<ExibirCancelamentoDto> dto = cancelamento.stream().map(c -> new ExibirCancelamentoDto(c))
				.collect(Collectors.toList());

		return ResponseEntity.ok(dto);
	}

	@PreAuthorize("hasRole('CLIENTE') or hasRole('ADMIN')")
	@PostMapping()
	public ResponseEntity<ExibirCancelamentoDto> adicionar(@Valid @RequestBody NovoCancelamentoDto dto) {
		Cancelamento cancelamento = cancelamentoService.converterCancelamentoDtoEmEntidade(dto);
		cancelamento = cancelamentoService.salvar(cancelamento);
		envioEmail.enviar(cancelamento.getPassagem().getUsuario().getEmail(), "Cancelamento de passagem efetuado com sucesso!", "");
		return new ResponseEntity<ExibirCancelamentoDto>(new ExibirCancelamentoDto(cancelamento), HttpStatus.CREATED);
	}

}
