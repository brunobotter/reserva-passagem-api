package br.com.bruno.reserva.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cancelamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cancelamentoId;

	@OneToOne
	private Passagem passagem;

	private LocalDateTime dataCancelamento;

	private String motivoCancelamento;

	;

	public Cancelamento(Long cancelamentoId, Passagem passagem, LocalDateTime dataCancelamento,
			String motivoCancelamento) {
		super();
		this.cancelamentoId = cancelamentoId;
		this.passagem = passagem;
		this.dataCancelamento = dataCancelamento;
		this.motivoCancelamento = motivoCancelamento;
	}

	public Cancelamento() {
		super();
	}

	public Cancelamento(Passagem passagem, LocalDateTime dataCancelamento, String motivoCancelamento) {
		super();
		this.passagem = passagem;
		this.dataCancelamento = dataCancelamento;
		this.motivoCancelamento = motivoCancelamento;
	}



	public Long getCancelamentoId() {
		return cancelamentoId;
	}

	public void setCancelamentoId(Long cancelamentoId) {
		this.cancelamentoId = cancelamentoId;
	}

	public Passagem getPassagem() {
		return passagem;
	}
	

	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}

	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(LocalDateTime dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

}
