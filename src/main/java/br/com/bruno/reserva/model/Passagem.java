package br.com.bruno.reserva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.bruno.reserva.dto.request.AtualizaPassagemDto;
import br.com.bruno.reserva.dto.request.NovaPassagemDto;

@Entity
public class Passagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passagemId;

	@ManyToOne
	private Onibus onibus;

	@ManyToOne
	private Usuario usuario;

	private int poltrona;

	private boolean cancelado = false;

	public Passagem() {
		super();
	}

	public Passagem(Onibus onibus, Usuario usuario, int poltrona) {
		super();
		this.onibus = onibus;
		this.usuario = usuario;
		this.poltrona = poltrona;
	}

	public Passagem(NovaPassagemDto dto) {
		super();
		this.poltrona = dto.getNumeroPoltrona();
	}

	public Passagem(AtualizaPassagemDto dto) {
		super();
		this.passagemId = dto.getPassagemId();
		this.onibus = dto.getOnibusId();
		this.usuario = dto.getUsuarioId();
		this.poltrona = dto.getNumeroPoltrona();
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public int getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(int poltrona) {
		this.poltrona = poltrona;
	}

	public Long getPassagemId() {
		return passagemId;
	}

	public void setPassagemId(Long passagemId) {
		this.passagemId = passagemId;
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
