package br.desafio.unidac.database.exception;

public class AlimentoJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AlimentoJaExisteException(String msg) {
		super(msg);
	}
	
	public AlimentoJaExisteException(String msg, Throwable causa) {
		super(msg, causa);
	}
}
