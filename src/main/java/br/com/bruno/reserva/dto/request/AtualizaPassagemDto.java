package br.com.bruno.reserva.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.bruno.reserva.model.Onibus;
import br.com.bruno.reserva.model.Passagem;
import br.com.bruno.reserva.model.Usuario;

public class AtualizaPassagemDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Preenchimento obrigatorio!")
	private Long passagemId;
	
	@NotNull(message = "Preenchimento obrigatorio!")
	private Onibus onibusId;
	
	@NotNull(message = "Preenchimento obrigatorio!")
	private Usuario usuarioId;
	
	@NotNull(message = "Preenchimento obrigatorio!")
	private int numeroPoltrona;
	
	public AtualizaPassagemDto(Passagem passagem) {
		this.passagemId = passagem.getPassagemId();
		this.onibusId = passagem.getOnibus();
		this.usuarioId = passagem.getUsuario();
		this.numeroPoltrona = passagem.getPoltrona();
	}
	
	
	
	public Long getPassagemId() {
		return passagemId;
	}



	public void setPassagemId(Long passagemId) {
		this.passagemId = passagemId;
	}



	public Onibus getOnibusId() {
		return onibusId;
	}
	public void setOnibusId(Onibus onibusId) {
		this.onibusId = onibusId;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	public int getNumeroPoltrona() {
		return numeroPoltrona;
	}
	public void setNumeroPoltrona(int numeroPoltrona) {
		this.numeroPoltrona = numeroPoltrona;
	}
	
	

}
