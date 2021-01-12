package br.com.bruno.reserva.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bruno.reserva.model.Onibus;

public class ExibirOnibusDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long onibusId;

	private List<ExibePoltronaDto> listaPoltrona;

	private int quantidadePoltronas;

	private String origem;

	private String destino;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime partida;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime chegada;
	
	public ExibirOnibusDto() {
		
	}

	public ExibirOnibusDto(Onibus onibus) {
		this.onibusId = onibus.getOnibusId();
		this.destino = onibus.getDestino().getNomeCidade();
		this.chegada = onibus.getChegada();
		this.partida = onibus.getPartida();
		this.origem = onibus.getOrigem().getNomeCidade();
		this.quantidadePoltronas = onibus.getQuantidadePoltronas();
		if(onibus.getListaPoltrona() != null)
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



	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
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
