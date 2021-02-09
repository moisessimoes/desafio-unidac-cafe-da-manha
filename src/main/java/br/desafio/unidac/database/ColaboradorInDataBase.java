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
import br.desafio.unidac.dominio.Colaborador;
import br.desafio.unidac.dominio.repositorios.CafeDaManhaRepository;
import br.desafio.unidac.dominio.repositorios.ColaboradorRepository;

public class ColaboradorInDataBase implements ColaboradorRepository, Serializable {
	
	private static final long serialVersionUID = 1L;

	
	/*Como o colaborador está sendo salvo pela primeira vez, a opcao de cafe tambem deve ser salva,
	 * 
	 * resultando em uma insecao dupla, uma para cada tabela.
	 * */
	
	@Override
	public void save(Colaborador colaborador, CafeDaManha cafe) {
		
		if(alimentoJaExiste(cafe.getAlimento())) return; //Antes de salvar, e verificado se o alimento ja existe ou nao.
		
		Connection connection = ConexaoBD.getConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		try {
			
			ps1 = connection.prepareStatement("INSERT INTO tbl_colaboradores (nome, cpf) values (?, ?);");
			
			ps1.setString(1, colaborador.getNome());
			ps1.setString(2, colaborador.getCpf());
			
			ps1.executeUpdate();
			ps1.close();
			
			System.out.println("O colaborador foi salvo com sucesso!");
			
			//====================================================================================================
			
			ps2 = connection.prepareStatement("INSERT INTO tbl_alimentos (alimento, colaborador_cpf) values (?, ?);");
			
			ps2.setString(1, cafe.getAlimento());
			ps2.setString(2, cafe.getColaboradorCpf());
			
			ps2.executeUpdate();
			ps2.close();
			
			System.out.println("O item foi salvo com sucesso!");
			
		} catch (SQLException sqle) {
			System.out.println("Erro ao salvar colaborador! " + sqle.getMessage());
			
		} 
	}
	
	
	
	
	@Override
	public void update(String novoNome,  String cpf) { //O CPF do colaborador nao pode ser alterado, pois ele e usado como foreign key na tabela de alimentos.
		
		Connection connection = ConexaoBD.getConnection();
		PreparedStatement ps = null;
		
		try {
				
			ps = connection.prepareStatement("UPDATE tbl_colaboradores SET nome = ? WHERE cpf = ?"); 
				
			ps.setString(1, novoNome);
			ps.setString(2, cpf);
				
			ps.executeUpdate();
			ps.close();
				
			System.out.println("Colaborador atualizado com sucesso!");
			
			
		} catch (SQLException sqle) {
			System.out.println("Erro ao Atualizar! " + sqle.getMessage());
		} 
	}

	
	@Override
	public void delete(String cpf) {
		
		Connection connection = ConexaoBD.getConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		/*Para excluir um colaborador e necessario excluir primeiro a(s) opcao(oes) de cafe que ele levou.
		 * 
		 * E depois o colaborador e excluido.
		 * 
		 * Isso se deve por causa do relacionamento das tabelas.
		 * 
		 * */
		
		try {
			
			ps1 = connection.prepareStatement("DELETE FROM tbl_alimentos WHERE colaborador_cpf = ?;");
			
			ps1.setString(1, cpf);
			
			ps1.executeUpdate();
			ps1.close();
			
			System.out.println("Os outros registros deste colaborador foram excluidos com sucesso!");
			
			//============================================================================================================
			
			ps2 = connection.prepareStatement("DELETE FROM tbl_colaboradores WHERE cpf = ?;");
			
			ps2.setString(1, cpf);
			
			ps2.executeUpdate();
			ps2.close();
			
			System.out.println("O colaborador foi excluido com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir colaborador!" + e.getMessage());
			
		} 
	}
	
	


	@Override
	public Colaborador findByCPF(String cpf) {
		
		Connection connection = ConexaoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet result = null;
		
		Colaborador colaborador = new Colaborador();
		
		try {
			
			ps = connection.prepareStatement("SELECT * FROM tbl_colaboradores WHERE cpf = ?;");
			
			ps.setString(1,  cpf);
			
			result = ps.executeQuery();
			
			while(result.next()) {
				
				if(result.getString("cpf").equals(cpf)) {
					
					colaborador.setNome(result.getString("nome"));
					colaborador.setCpf(result.getString("cpf"));
					
				} else {
					
					return null;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		
		return colaborador;
	}

	
	@Override
	public List<Colaborador> findAll() {
		
		Connection connection = ConexaoBD.getConnection();
		PreparedStatement ps = null;
		ResultSet result = null;
		
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		
		try {
			
			ps = connection.prepareStatement("SELECT * FROM tbl_colaboradores;");
			
			result = ps.executeQuery();
			
			while(result.next()) {
				
				Colaborador colaborador = new Colaborador(result.getString("nome"), result.getString("cpf"));
				
				colaboradores.add(colaborador);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
	
		} 
		
		return colaboradores;
	}


	@Override
	public boolean alimentoJaExiste(String alimento) {
		
		CafeDaManhaRepository coffee = new CafeDaManhaInDataBase();
		
		for (CafeDaManha cafe : coffee.findAll()) {
			
			if(cafe.getAlimento().equals(alimento)) {
				
				return true;
			}
		}
		return false;
	}
}
