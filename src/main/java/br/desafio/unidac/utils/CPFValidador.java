package br.desafio.unidac.utils;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

public class CPFValidador {
	
	
	public static boolean validarCPF(String cpf) { //https://www.alura.com.br/artigos/validando-cpf-com-java-atraves-do-stella
		
		CPFValidator validadorCPF = new CPFValidator(); //Classe da API Caelum Stella para validar CPF.
		
		List<ValidationMessage> erros = validadorCPF.invalidMessagesFor(cpf);
		
		if(erros.size() > 0) return false;
		
		else
			return true;
	}
}
