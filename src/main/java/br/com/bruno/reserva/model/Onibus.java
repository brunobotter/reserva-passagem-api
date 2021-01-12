package br.com.bruno.reserva.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Onibus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long onibusId;

	@OneToMany
	private List<Poltrona> listaPoltrona;

	private int quantidadePoltronas;

	@ManyToOne
	private Cidades origem;

	@ManyToOne
	private Cidades destino;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime partida;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime chegada;

	public Onibus(int quantidadePoltronas, Cidades origem, Cidades destino, LocalDateTime partida,
			LocalDateTime chegada) {
		super();
		this.quantidadePoltronas = quantidadePoltronas;
		this.origem = origem;
		this.destino = destino;
		this.partida = partida;
		this.chegada = chegada;
	}

	public Long getOnibusId() {
		return onibusId;
	}

	public void setOnibusId(Long onibusId) {
		this.onibusId = onibusId;
	}

	public List<Poltrona> getListaPoltrona() {
		return listaPoltrona;
	}

	public void setListaPoltrona(List<Poltrona> listaPoltrona) {
		this.listaPoltrona = listaPoltrona;
	}

	public int getQuantidadePoltronas() {
		return quantidadePoltronas;
	}

	public void setQuantidadePoltronas(int quantidadePoltronas) {
		this.quantidadePoltronas = quantidadePoltronas;
	}

	public Cidades getOrigem() {
		return origem;
	}

	public void setOrigem(Cidades origem) {
		this.origem = origem;
	}

	public Cidades getDestino() {
		return destino;
	}

	public void setDestino(Cidades destino) {
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

	public Onibus() {
		super();
	}

	public Onibus(Long onibusId, List<Poltrona> listaPoltrona, int quantidadePoltronas, Cidades origem, Cidades destino,
			LocalDateTime horaPartida, LocalDateTime horaChegada, LocalDate dataViagem) {
		super();
		this.onibusId = onibusId;
		this.listaPoltrona = listaPoltrona;
		this.quantidadePoltronas = quantidadePoltronas;
		this.origem = origem;
		this.destino = destino;
		this.partida = horaPartida;
		this.chegada = horaChegada;
	}

}
