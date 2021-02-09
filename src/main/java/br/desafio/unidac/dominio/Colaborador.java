package br.desafio.unidac.dominio;

import java.io.Serializable;

public class Colaborador implements Serializable {
	
	
	/*Classe 'Colaborador' e uma entidade que sera salva no banco.
	 * 
	 * Contendo os respectivos atributos de acordo com o documento de especificacao.
	 * 
	 * OBS: Quando for salvar um novo colaborador, tambem sera salvo o que ele levou para o cafe.
	 * 
	 * Se o mesmo colaborador levar mais de uma opcao de cafe, essa segunda opcao sera salva em outra tabela.
	 * 
	 * */
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf; //Como o CPF nao pode se repetir, ele sera a chave primaria da tabela
	
	public Colaborador() {}


	public Colaborador(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Colaborador other = (Colaborador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
