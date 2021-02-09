package br.desafio.unidac.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.desafio.unidac.dominio.CafeDaManha;
import br.desafio.unidac.dominio.Colaborador;
import br.desafio.unidac.dominio.repositorios.CafeDaManhaRepository;
import br.desafio.unidac.dominio.repositorios.ColaboradorComCafeRepository;
import br.desafio.unidac.dominio.repositorios.ColaboradorRepository;
import br.desafio.unidac.utils.ColaboradorComCafe;

public class ColaboradorComCafeInDataBase implements ColaboradorComCafeRepository, Serializable {
	
	private static final long serialVersionUID = 1L;

	private ColaboradorRepository colaboradorRepository = new ColaboradorInDataBase();
	
	private CafeDaManhaRepository cafeRepository = new CafeDaManhaInDataBase();
	
	@Override
	public List<ColaboradorComCafe> listarTodosOsColaboradoresComCafe() { //Lista os colaboradoradores que levaram uma ou mais de uma opcao de cafe
		
		List<ColaboradorComCafe> lista = new ArrayList<ColaboradorComCafe>();
		
		for (Colaborador colab : colaboradorRepository.findAll()) {
			
			for (CafeDaManha cafe : cafeRepository.findAll()) {
				
				if(colab.getCpf().equals(cafe.getColaboradorCpf())) {
					
					ColaboradorComCafe colaboradorComCafe = new ColaboradorComCafe(colab.getNome(), colab.getCpf(), cafe.getAlimento());
					
					lista.add(colaboradorComCafe);
				}
			}
		}
		return lista;
	}
}
