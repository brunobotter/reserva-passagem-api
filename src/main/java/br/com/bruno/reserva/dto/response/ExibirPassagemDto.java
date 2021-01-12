package br.com.bruno.reserva.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bruno.reserva.model.Passagem;

public class ExibirPassagemDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long passagemId;
	private Long onibusId;
	private String nomePassageiro;
	
	private String cpf;
	private int numeroPoltrona;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime partida;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime chegada;
	private String cidadeOrigem;
	private String cidadeDestino;
	private boolean cancelado;

	public ExibirPassagemDto() {

	}

	public ExibirPassagemDto(Passagem passagem) {
		this.passagemId = passagem.getPassagemId();
		this.onibusId = passagem.getOnibus().getOnibusId();
		this.nomePassageiro = passagem.getUsuario().getNome();
		this.cpf = passagem.getUsuario().getCpf();
		this.numeroPoltrona = passagem.getPoltrona();
		this.partida = passagem.getOnibus().getPartida();
		this.chegada = passagem.getOnibus().getChegada();
		this.cidadeDestino = passagem.getOnibus().getDestino().getNomeCidade();
		this.cidadeOrigem = passagem.getOnibus().getOrigem().getNomeCidade();
		this.cancelado = passagem.isCancelado();
	}
	
	

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public Long getOnibusId() {
		return onibusId;
	}

	public void setOnibusId(Long onibusId) {
		this.onibusId = onibusId;
	}

	public Long getPassagemId() {
		return passagemId;
	}

	public void setPassagemId(Long passagemId) {
		this.passagemId = passagemId;
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getNumeroPoltrona() {
		return numeroPoltrona;
	}

	public void setNumeroPoltrona(int numeroPoltrona) {
		this.numeroPoltrona = numeroPoltrona;
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

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

}
