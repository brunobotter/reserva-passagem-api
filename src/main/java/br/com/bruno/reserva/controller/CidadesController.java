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

import br.com.bruno.reserva.dto.request.NovaCidadeDto;
import br.com.bruno.reserva.dto.response.ExibirCidadeDto;
import br.com.bruno.reserva.model.Cidades;
import br.com.bruno.reserva.service.CidadesService;

@RestController
@RequestMapping("api/cidades")
public class CidadesController {
	
	@Autowired
	private CidadesService cidadesService;
	
	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@GetMapping("{id}")
	public ResponseEntity<ExibirCidadeDto> buscaPorId(@PathVariable Long id){
		Cidades cidades = cidadesService.buscar(id);
		return new ResponseEntity<ExibirCidadeDto>(new ExibirCidadeDto(cidades), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<ExibirCidadeDto>> buscaTodos(){
		List<Cidades> cidades = cidadesService.listarTodos();
		List<ExibirCidadeDto> dto = 
				cidades.stream().map(c -> new ExibirCidadeDto(c)).collect(Collectors.toList());
		return  ResponseEntity.ok(dto);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		cidadesService.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@PostMapping()
	public ResponseEntity<ExibirCidadeDto> adicionar(@Valid @RequestBody NovaCidadeDto dto){
		Cidades cidade = cidadesService.converteNovaCidadeDTOEmEntidade(dto);
		cidade = cidadesService.salvar(cidade);
		return new ResponseEntity<ExibirCidadeDto>(new ExibirCidadeDto(cidade), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<ExibirCidadeDto> atualizar(@Valid @RequestBody NovaCidadeDto dto, @PathVariable Long id){
		Cidades cidade = cidadesService.converteNovaCidadeDTOEmEntidade(dto);
		cidade = cidadesService.atualizar(cidade, id);
		return new ResponseEntity<ExibirCidadeDto>(new ExibirCidadeDto(cidade), HttpStatus.OK);
	}
}
