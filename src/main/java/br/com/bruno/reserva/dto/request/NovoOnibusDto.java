package br.com.bruno.reserva.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bruno.reserva.dto.response.ExibePoltronaDto;
import br.com.bruno.reserva.model.Onibus;

public class NovoOnibusDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long onibusId;

	private List<ExibePoltronaDto> listaPoltrona;

	@NotNull(message = "Preenchimento obrigatorio!")
	private int quantidadePoltronas;

	
	private Long origemId;

	
	private Long destinoId;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime partida;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime chegada;


	public NovoOnibusDto() {

	}

	public NovoOnibusDto(Onibus onibus) {
		this.onibusId = onibus.getOnibusId();
		this.origemId = onibus.getDestino().getId();
		this.chegada = onibus.getChegada();
		this.partida = onibus.getPartida();
		this.destinoId = onibus.getOrigem().getId();
		this.quantidadePoltronas = onibus.getQuantidadePoltronas();
		this.listaPoltrona = onibus.getListaPoltrona().stream().map(s -> new ExibePoltronaDto(s))
				.collect(Collectors.toList());
	}

	public Long getOnibusId() {
		return onibusId;
	}

	public void setOnibusId(Long onibusId) {
		this.onibusId = onibusId;
	}

	public List<ExibePoltronaDto> getListaPoltrona() {
		return listaPoltrona;
	}

	public void setListaPoltrona(List<ExibePoltronaDto> listaPoltrona) {
		this.listaPoltrona = listaPoltrona;
	}

	public int getQuantidadePoltronas() {
		return quantidadePoltronas;
	}

	public void setQuantidadePoltronas(int quantidadePoltronas) {
		this.quantidadePoltronas = quantidadePoltronas;
	}

	

	public Long getOrigemId() {
		return origemId;
	}

	public void setOrigemId(Long origemId) {
		this.origemId = origemId;
	}

	public Long getDestinoId() {
		return destinoId;
	}

	public void setDestinoId(Long destinoId) {
		this.destinoId = destinoId;
	}

	public LocalDateTime getPartida() {
		return partida;
	}

	public void setPartida(LocalDateTime partida) {
		this.partida = partida;
	}

	public LocalDateTime getChegada() {
		return chegada;
	}

	public void setChegada(LocalDateTime chegada) {
		this.chegada = chegada;
	}

	
}
