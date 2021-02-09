package br.desafio.unidac.utils;

import java.io.Serializable;

public class ColaboradorComCafe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	//Essa classe vai servir para exibir os colaboradores e o que cada um levou para o cafe.
	
	
	private String nome;
	private String cpf;
	private String alimento;
	
	public ColaboradorComCafe() {}
	

	public ColaboradorComCafe(String nome, String cpf, String alimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.alimento = alimento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getAlimento() {
		return alimento;
	}


	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}
}
