package br.com.bruno.reserva.dto.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bruno.reserva.model.Usuario;
import br.com.bruno.reserva.model.enuns.Role;

public class ExibirClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long clienteId;

	private String nome;

	@Email
	private String email;

	@CPF
	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private Set<Role> perfies;

	public ExibirClienteDto() {
		super();
	}

	public ExibirClienteDto(Usuario usuario) {
		super();
		this.clienteId = usuario.getUsuarioId();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.email = usuario.getEmail();
		this.nome = usuario.getNome();
		this.perfies = usuario.getPerfis();
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Role> getPerfies() {
		return perfies;
	}

	public void setPerfies(Set<Role> perfies) {
		this.perfies = perfies;
	}

}
