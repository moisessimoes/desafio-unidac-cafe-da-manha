package br.desafio.unidac.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.desafio.unidac.database.conexao.ConexaoBD;
import br.desafio.unidac.dominio.CafeDaManha;
import br.desafio.unidac.dominio.repositorios.CafeDaManhaRepository;

public class CafeDaManhaInDataBase implements CafeDaManhaRepository, Serializable {
	
	
	private static final long serialVersionUID = 1L;


	@Override
	public void save(CafeDaManha cafe) {
		
		if(alimentoJaExiste(cafe)) return;
		
		Connection connection = ConexaoBD.getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = connection.prepareStatement("INSERT INTO tbl_alimentos (alimento, colaborador_cpf) values (?, ?);");
			
			ps.setString(1, cafe.getAlimento());
			ps.setString(2, cafe.getColaboradorCpf());
			
			ps.executeUpdate();
			ps.close();
			
			System.out.println("O item foi salvo com sucesso!");
			
		} catch (SQLException sqle) {
			System.out.println("Erro ao salvar item! " + sqle.getMessage());
			
		} 
	}

	@Override
	public void update(String alimentoAntigo, String novoAlimento) {
		
		Connection connection = ConexaoBD.getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = connection.prepareStatement("UPDATE tbl_alimentos SET alimento = ? WHERE alimento = ?;");
			
			ps.setString(1, novoAlimento);
			ps.setString(2, alimentoAntigo);
			
			ps.executeUpdate();
			ps.close();
			
			System.out.println("Atualizado com sucesso!");
			
		} catch (SQLException sqle) {
			System.out.println("Erro ao atualizar item! " + sqle.getMessage());
			
		} 
	}

	
	@Override
	public void delete(String alimento, String cpf) {
		
		try {
			
			if(cpfAparaceMaisDeUmaVez(cpf)) {
				
				Connection connection = ConexaoBD.getConnection();
				PreparedStatement ps = null;
				
				ps = connection.prepareStatement("DELETE FROM tbl_alimentos WHERE alimento = ?;");
				
				ps.setString(1, alimento);
				
				ps.executeUpdate();
				ps.close();
				
				System.out.println("Esta opção de café foi excluída com sucesso!");
				
			} else {
				
				System.out.println("Não é possível exluir o item! Pois ele é a única opção de café relacionada com o CPF: " + cpf);
				return;
			}
			
		} catch (SQLException sqle) {
			System.out.println("Erro ao excluir item! " + sqle.getMessage());
		} 
	}
	
	
	
	@Override
	public boolean cpfAparaceMaisDeUmaVez(String cpf) {
		
		int cont = 0;
		
		for (CafeDaManha cafe : findAll()) {
			
			if(cafe.getColaboradorCpf().equals(cpf)) {
				
				cont++;
			}
		}
		
		if(cont > 1) return true; //Significa que o colaborador tem mais de uma opcao de alimento cadastrado.
		
		return false; //Significa que o colaborador tem apenas uma opcao de alimento cadastrado.
	}
	
	
	
	@Override
	public CafeDaManha findByNome(String nome) {
		
		Connection connection = ConexaoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet result = null;
		
		CafeDaManha cafe = new CafeDaManha();
		
		try {
			
			ps = connection.prepareStatement("SELECT * FROM tbl_alimentos WHERE alimento = ?;");
			
			ps.setString(1, nome);
			
			result = ps.executeQuery();
			
			while(result.next()) {
				
				if(result.getString("alimento").equals(nome)) {
					
					cafe.setAlimento(nome);
					cafe.setColaboradorCpf(result.getString("colaborador_cpf"));
					
				} else {
					
					return null;
				}
			}
			
			ps.close();
			result.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		} 
		
		return cafe;
	}

	
	@Override
	public List<CafeDaManha> findAll() {
		
		Connection connection = ConexaoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet result = null;
		
		List<CafeDaManha> menu = new ArrayList<CafeDaManha>();
		
		try {
			
			ps = connection.prepareStatement("SELECT * FROM tbl_alimentos;");
			
			result = ps.executeQuery();
			
			while(result.next()) {
				
				CafeDaManha cafe = new CafeDaManha(result.getString("alimento"), result.getString("colaborador_cpf"));
				
				menu.add(cafe);
			}
			
			ps.close();
			result.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		
		return menu;
	}

	
	public boolean alimentoJaExiste(CafeDaManha cafe) {
		
		for (CafeDaManha coffee : findAll()) {
			
			if(cafe.getAlimento().equals(coffee.getAlimento())) {
				
				return true;
			}
		}
		return false;
	}
}
