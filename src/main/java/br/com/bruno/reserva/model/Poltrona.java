package br.com.bruno.reserva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bruno.reserva.dto.response.ExibePoltronaDto;

@Entity
public class Poltrona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long poltronaId;

	private int numeroPoltrona;

	private boolean ocupado = false;

	@JsonIgnore
	@ManyToOne
	private Onibus onibus;

	public Long getPoltronaId() {
		return poltronaId;
	}

	public void setPoltronaId(Long poltronaId) {
		this.poltronaId = poltronaId;
	}

	public int getNumeroPoltrona() {
		return numeroPoltrona;
	}

	public void setNumeroPoltrona(int numeroPoltrona) {
		this.numeroPoltrona = numeroPoltrona;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}

	public Poltrona() {
		super();
	}

	public Poltrona(int numeroPoltrona, boolean ocupado) {
		super();
		this.numeroPoltrona = numeroPoltrona;
		this.ocupado = ocupado;
	}

	public Poltrona(int numeroPoltrona, boolean ocupado, Onibus onibus) {
		super();
		this.numeroPoltrona = numeroPoltrona;
		this.ocupado = ocupado;
		this.onibus = onibus;
	}

	public Poltrona(ExibePoltronaDto dto) {
		super();
		this.poltronaId = dto.getPoltronaId();
		this.numeroPoltrona = dto.getNumeroPoltrona();
		this.ocupado = dto.isOcupado();
	}
	
}
