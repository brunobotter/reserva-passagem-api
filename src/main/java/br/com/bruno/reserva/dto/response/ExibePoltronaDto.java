package br.com.bruno.reserva.dto.response;

import br.com.bruno.reserva.model.Poltrona;

public class ExibePoltronaDto {

	private Long poltronaId;

	private int numeroPoltrona;

	private boolean ocupado;

	public ExibePoltronaDto(Poltrona poltrona) {
		this.poltronaId = poltrona.getPoltronaId();
		this.numeroPoltrona = poltrona.getNumeroPoltrona();
		this.ocupado = poltrona.isOcupado();
	}
	
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
	
	
}
