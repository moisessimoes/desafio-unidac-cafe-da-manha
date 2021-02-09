package br.desafio.unidac.servicos;

import java.io.Serializable;
import java.util.List;

import br.desafio.unidac.database.CafeDaManhaInDataBase;
import br.desafio.unidac.dominio.CafeDaManha;
import br.desafio.unidac.dominio.repositorios.CafeDaManhaRepository;

public class CafeDaManhaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CafeDaManhaRepository cafeRepository = new CafeDaManhaInDataBase();
	
	
	public void salvar(CafeDaManha cafe) {
		
		cafeRepository.save(cafe);
	}
	
	
	
	public void atualizar(String alimentoAntigo, String novoAlimento) {
		
		cafeRepository.update(alimentoAntigo, novoAlimento);
	}
	
	
	
	public void deletar(String alimento, String cpf) {
		
		cafeRepository.delete(alimento, cpf);
	}
	
	
	public CafeDaManha buscarPorNome(String alimento) {
		
		return cafeRepository.findByNome(alimento);
	}
	
	
	
	public List<CafeDaManha> getOpcoes() {
		
		return cafeRepository.findAll();
	}
	
	
	public boolean alimentoJaExiste(CafeDaManha cafe) {
		
		return cafeRepository.alimentoJaExiste(cafe);
	}
	
	
	public boolean podeExcluirAlimento(String cpf) {
		
		return cafeRepository.cpfAparaceMaisDeUmaVez(cpf);
	}
}
