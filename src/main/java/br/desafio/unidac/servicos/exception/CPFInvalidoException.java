package br.desafio.unidac.servicos.exception;

public class CPFInvalidoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	

	public CPFInvalidoException(String msg) {
		super(msg);
	}
	
	public CPFInvalidoException(String msg, Throwable causa) {
		super(msg, causa);
	}
}
