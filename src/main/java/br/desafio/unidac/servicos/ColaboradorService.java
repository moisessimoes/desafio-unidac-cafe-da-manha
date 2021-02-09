package br.desafio.unidac.servicos;

import java.io.Serializable;
import java.util.List;

import br.desafio.unidac.database.ColaboradorComCafeInDataBase;
import br.desafio.unidac.database.ColaboradorInDataBase;
import br.desafio.unidac.dominio.CafeDaManha;
import br.desafio.unidac.dominio.Colaborador;
import br.desafio.unidac.dominio.repositorios.ColaboradorComCafeRepository;
import br.desafio.unidac.dominio.repositorios.ColaboradorRepository;
import br.desafio.unidac.servicos.exception.CPFInvalidoException;
import br.desafio.unidac.utils.CPFValidador;
import br.desafio.unidac.utils.ColaboradorComCafe;

public class ColaboradorService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ColaboradorRepository colaboradorRepository = new ColaboradorInDataBase();
	
	private ColaboradorComCafeRepository colaboradorComCafeRepository = new ColaboradorComCafeInDataBase();
	
	
	public void salvar(Colaborador colaborador, CafeDaManha cafe) throws CPFInvalidoException {
		
		if(CPFValidador.validarCPF(colaborador.getCpf())) {
			
			colaboradorRepository.save(colaborador, cafe);
			
		} else {
			
			throw new CPFInvalidoException("O CPF inserido é inválido!");
		}
	}
	
	
	public void atualizar(String novoNome, String cpf) {
		
		colaboradorRepository.update(novoNome, cpf);
	}
	
	
	public void deletar(String cpf) {
		
		colaboradorRepository.delete(cpf);
	}
	
	
	
	public Colaborador buscarPorCPF(String cpf) {
		
		return colaboradorRepository.findByCPF(cpf);
	}
	
	
	
	public List<Colaborador> getColaboradores() {
		
		return colaboradorRepository.findAll();
	}
	
	
	public boolean alimentoJaExiste(String alimento) {
		
		return colaboradorRepository.alimentoJaExiste(alimento);
	}
	
	
	public List<ColaboradorComCafe> getColaboradoresESuasOpcoes() { //Esse metodo vai retornar uma lista com os colaboradores e suas respectivas opcoes levadas.
		
		if(colaboradorComCafeRepository.listarTodosOsColaboradoresComCafe().isEmpty()) return null;
		
		return colaboradorComCafeRepository.listarTodosOsColaboradoresComCafe();
	}
}
