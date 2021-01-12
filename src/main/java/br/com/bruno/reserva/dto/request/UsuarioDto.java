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

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long usuarioId;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	@Email(message = "Email informado e invalido")
	private String email;

	@CPF(message = "O CPF informado é inválido")
	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private Set<Role> perfies;
	
	private String senha;
	
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioDto() {
		super();
	}

	public UsuarioDto(Usuario usuario) {
		super();
		this.usuarioId = usuario.getUsuarioId();
		this.nome = usuario.getNome();
		this.senha = usuario.getSenha();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.perfies = usuario.getPerfis();
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
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
