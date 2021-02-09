package br.desafio.unidac.dominio.repositorios;

import java.util.List;

import br.desafio.unidac.dominio.CafeDaManha;

public interface CafeDaManhaRepository {
	
	public void save(CafeDaManha cafe);
	
	public void update(String alimentoAntigo, String novoAlimento);
	
	public void delete(String alimento, String cpf);
	
	public CafeDaManha findByNome(String nome);
	
	public List<CafeDaManha> findAll();
	
	public boolean alimentoJaExiste(CafeDaManha cafe);
	
	public boolean cpfAparaceMaisDeUmaVez(String cpf);
	
}
