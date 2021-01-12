package br.com.bruno.reserva.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class NovaCidadeDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatorio!")
	private String nomeCidade;

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	
}
