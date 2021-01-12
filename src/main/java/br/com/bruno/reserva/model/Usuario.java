package br.com.bruno.reserva.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bruno.reserva.dto.request.UsuarioDto;
import br.com.bruno.reserva.model.enuns.Role;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long usuarioId;

	@Column(name = "nome")
	private String nome;

	@JsonIgnore
	@Column(name = "senha")
	private String senha;

	@Column(name = "email")
	private String email;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	public void addPerfil(Role perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public Usuario() {

	}


	public Usuario(Long usuarioId, String nome, String senha, String cpf) {
		super();
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
	}
	
	
	public Usuario(UsuarioDto dto) {
		super();
		this.nome = dto.getNome();
		this.senha = dto.getSenha();
		this.cpf = dto.getCpf();
		this.email = dto.getEmail();
		this.dataNascimento = dto.getDataNascimento();
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

	public Set<Role> getPerfis() {
		return this.perfis.stream().map(p -> Role.toEnum(p)).collect(Collectors.toSet());
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarioId == null) ? 0 : usuarioId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		return true;
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

}
