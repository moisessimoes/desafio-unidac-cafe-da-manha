package br.desafio.unidac.dominio;

import java.io.Serializable;

public class CafeDaManha implements Serializable {
	
	/*Classe 'CafeDaManha' e uma entidade que sera salva no banco.
	 * 
	 * Contendo os respectivos atributos de acordo com o documento de especificacao.
	 * 
	 * */
	
	private static final long serialVersionUID = 1L;
	
	private String alimento; //Como o Alimento nao pode se repetir, ele sera a chave primaria da tabela
	private String colaboradorCpf;
	
	public CafeDaManha() {}


	public CafeDaManha(String alimento, String colaboradorCPF) {
		super();
		this.alimento = alimento;
		this.colaboradorCpf = colaboradorCPF;
	}
	

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public String getColaboradorCpf() {
		return colaboradorCpf;
	}

	public void setColaboradorCpf(String colaboradorCpf) {
		this.colaboradorCpf = colaboradorCpf;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alimento == null) ? 0 : alimento.hashCode());
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
		CafeDaManha other = (CafeDaManha) obj;
		if (alimento == null) {
			if (other.alimento != null)
				return false;
		} else if (!alimento.equals(other.alimento))
			return false;
		return true;
	}
}
