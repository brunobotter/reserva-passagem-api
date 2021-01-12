package br.com.bruno.reserva.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bruno.reserva.model.Cancelamento;

public class ExibirCancelamentoDto {

	private Long cancelamentoId;
	private String nomePassageiro;
	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataCancelamento;

	private int numeroPoltrona;
	private String origem;
	private String destino;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime partida;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime chegada;
	private String motivo;
	private boolean cancelado;

	public ExibirCancelamentoDto() {

	}

	public ExibirCancelamentoDto(Cancelamento cancelamento) {
		this.cancelamentoId = cancelamento.getCancelamentoId();
		this.nomePassageiro = cancelamento.getPassagem().getUsuario().getNome();
		this.cpf = cancelamento.getPassagem().getUsuario().getCpf();
		this.dataCancelamento = cancelamento.getDataCancelamento();
		this.numeroPoltrona = cancelamento.getPassagem().getPoltrona();
		this.origem = cancelamento.getPassagem().getOnibus().getOrigem().getNomeCidade();
		this.destino = cancelamento.getPassagem().getOnibus().getDestino().getNomeCidade();
		this.partida = cancelamento.getPassagem().getOnibus().getPartida();
		this.chegada = cancelamento.getPassagem().getOnibus().getChegada();
		this.motivo = cancelamento.getMotivoCancelamento();
		this.cancelado = cancelamento.getPassagem().isCancelado();
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public Long getCancelamentoId() {
		return cancelamentoId;
	}

	public void setCancelamentoId(Long cancelamentoId) {
		this.cancelamentoId = cancelamentoId;
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

	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(LocalDateTime dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public int getNumeroPoltrona() {
		return numeroPoltrona;
	}

	public void setNumeroPoltrona(int numeroPoltrona) {
		this.numeroPoltrona = numeroPoltrona;
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

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
