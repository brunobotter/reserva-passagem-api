package br.com.bruno.reserva.dto.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bruno.reserva.model.Usuario;
import br.com.bruno.reserva.model.enuns.Role;

public class NovoClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String senha;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email informado e invalido")
	private String email;

	@NotEmpty(message = "Preenchimento obrigatório")
	@CPF(message = "O CPF informado é inválido")
	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private Set<Role> perfies;

	public NovoClienteDto() {
		super();
	}

	public NovoClienteDto(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.senha = usuario.getSenha();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.perfies = usuario.getPerfis();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
