package br.com.bruno.reserva.dto.response;

import java.io.Serializable;

import br.com.bruno.reserva.model.Cidades;

public class ExibirCidadeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long cidadeId;

	private String nomeCidade;

	public ExibirCidadeDto() {
		super();
	}

	public ExibirCidadeDto(Cidades cidade) {
		super();
		this.cidadeId = cidade.getId();
		this.nomeCidade = cidade.getNomeCidade();
	}

	public Long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Long cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

}
