package br.com.bruno.reserva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.bruno.reserva.dto.request.NovaCidadeDto;

@Entity
public class Cidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cidadeId;

	private String nomeCidade;

	public Cidades() {
		super();
	}

	public Cidades(Long cidadeId, String nomeCidade) {
		super();
		this.cidadeId = cidadeId;
		this.nomeCidade = nomeCidade;
	}
	
	public Cidades(NovaCidadeDto dto) {
		this.nomeCidade = dto.getNomeCidade();
	}

	public Long getId() {
		return cidadeId;
	}

	public void setId(Long id) {
		this.cidadeId = id;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

}
