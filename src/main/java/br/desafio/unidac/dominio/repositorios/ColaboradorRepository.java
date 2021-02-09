package br.desafio.unidac.dominio.repositorios;

import java.util.List;

import br.desafio.unidac.dominio.CafeDaManha;
import br.desafio.unidac.dominio.Colaborador;

public interface ColaboradorRepository {
	
	public void save(Colaborador colaborador, CafeDaManha cafe);
	
	public void update(String novoNome, String cpf);
	
	public void delete(String cpf);
	
	public Colaborador findByCPF(String cpf);
	
	public List<Colaborador> findAll();
	
	public boolean alimentoJaExiste(String alimento);

}
