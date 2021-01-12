package br.com.bruno.reserva.exception;

public class ObjetoNaoEncontradoException extends NullPointerException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	

}
