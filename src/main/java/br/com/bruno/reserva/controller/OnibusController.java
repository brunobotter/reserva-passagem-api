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

import br.com.bruno.reserva.dto.request.NovoOnibusDto;
import br.com.bruno.reserva.dto.response.ExibirOnibusDto;
import br.com.bruno.reserva.model.Onibus;
import br.com.bruno.reserva.service.OnibusService;

@RestController
@RequestMapping("api/onibus")
public class OnibusController {
	
	@Autowired
	private OnibusService onibusService;
	
	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@GetMapping("{id}")
	public ResponseEntity<ExibirOnibusDto> buscaPorId(@PathVariable Long id){
		Onibus onibus = onibusService.buscar(id);
		return ResponseEntity.ok(new ExibirOnibusDto(onibus));
	}
	
	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<ExibirOnibusDto>> buscaTodos(){
		List<Onibus> onibus = onibusService.listarTodos();
		List<ExibirOnibusDto> dto = onibus.stream().map(
				o -> new ExibirOnibusDto(o)).collect(Collectors.toList());
		return ResponseEntity.ok(dto);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		onibusService.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@PostMapping()
	public ResponseEntity<ExibirOnibusDto> adicionar(@Valid @RequestBody NovoOnibusDto dto){
		Onibus onibus = onibusService.converteNovoOnibusDTOEmEntidade(dto);
		onibus = onibusService.salvar(onibus);
		return new ResponseEntity<ExibirOnibusDto>(new ExibirOnibusDto(onibus), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('FUNCIONARIO') or hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<ExibirOnibusDto> atualizar(@Valid @RequestBody NovoOnibusDto dto, @PathVariable Long id){
		Onibus onibus = onibusService.converteNovoOnibusDTOEmEntidade(dto);
		onibus = onibusService.atualizar(onibus, id);
		return new ResponseEntity<ExibirOnibusDto>(new ExibirOnibusDto(onibus), HttpStatus.OK);
	}
}
