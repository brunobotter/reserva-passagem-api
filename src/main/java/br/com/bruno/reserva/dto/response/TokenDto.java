package br.com.bruno.reserva.dto.response;

public class TokenDto {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TokenDto(String token) {
		super();
		this.token = token;
	}

}
