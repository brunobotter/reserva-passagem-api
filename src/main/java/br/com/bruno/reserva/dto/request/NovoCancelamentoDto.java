package br.com.bruno.reserva.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.bruno.reserva.model.Cancelamento;

public class NovoCancelamentoDto {
	
	@NotNull(message = "Preenchimento obrigatorio!")
	private Long passagemId;

	@NotEmpty(message = "Preenchimento obrigatorio!")
	private String motivoCancelamento;
	
	public NovoCancelamentoDto() {
		
	}

	public NovoCancelamentoDto(Cancelamento cancelamento) {
		this.motivoCancelamento = cancelamento.getMotivoCancelamento();
		this.passagemId = cancelamento.getPassagem().getPassagemId();
	}

	public Long getPassagemId() {
		return passagemId;
	}

	public void setPassagemId(Long passagemId) {
		this.passagemId = passagemId;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

}
