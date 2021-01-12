package br.com.bruno.reserva.dto.request;

import java.io.Serializable;

import br.com.bruno.reserva.model.Passagem;

public class NovaPassagemDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long onibusId;
	
	private Long usuarioId;
	
	private int numeroPoltrona;

	public NovaPassagemDto() {
		
	}
	
	public NovaPassagemDto(Passagem passagem) {
		this.onibusId = passagem.getOnibus().getOnibusId();
		this.usuarioId = passagem.getUsuario().getUsuarioId();
		this.numeroPoltrona = passagem.getPoltrona();
	}
	

	public Long getOnibusId() {
		return onibusId;
	}

	public void setOnibusId(Long onibusId) {
		this.onibusId = onibusId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getNumeroPoltrona() {
		return numeroPoltrona;
	}
	public void setNumeroPoltrona(int numeroPoltrona) {
		this.numeroPoltrona = numeroPoltrona;
	}
	
	
	
}
