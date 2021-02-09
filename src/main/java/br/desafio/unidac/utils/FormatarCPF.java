package br.desafio.unidac.utils;

import java.io.Serializable;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;

public class FormatarCPF implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Formatter formatadorCPF = new CPFFormatter(); //Pertence a API da Stella Caelum para trabalhar com CPF.
	
	
	public String cpfFormatter(String cpf) { //https://faroljava.wordpress.com/2010/05/01/stella-caelum/
		
		return formatadorCPF.format(cpf);
	}
}
