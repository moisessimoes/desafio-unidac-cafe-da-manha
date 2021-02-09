package br.desafio.unidac.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.desafio.unidac.dominio.CafeDaManha;
import br.desafio.unidac.dominio.Colaborador;
import br.desafio.unidac.servicos.ColaboradorService;
import br.desafio.unidac.utils.ColaboradorComCafe;

@Named
@ViewScoped
public class ColaboradorBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ColaboradorService colaboradorService = new ColaboradorService();
	
	private Colaborador colaborador;
	private CafeDaManha cafe;
	
	private String novoNome; //Servira caso seja para editar o colaborador.
	private String cpf; //Servira caso seja para editar o colaborador.
	private String cpfRemover; //Serve para remover o colaborador
	
	
	
	public void iniciar() {
		
		try {
			
			if(colaborador == null) { 
				
				colaborador = new Colaborador(); //Aqui estou criando o colaborador.
				
				cafe = new CafeDaManha(); //Aqui estou criando o cafe, que sera oq o colaborador vai levar primeiro.
			} 
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
		}
	}
	
	
	
	public String salvar() {
		
		try {
			
			cafe.setColaboradorCpf(colaborador.getCpf());
				
			colaboradorService.salvar(colaborador, cafe);
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		
		reportarMensagemDeSucesso("Olá " + colaborador.getNome() +"! " + " Obrigado por contribuir com " + cafe.getAlimento() + " para o café da manhã da Unidac.");
		
		return EnderecoDasPaginasWEB.PAGINA_PRINCIPAL;
	}
	
	
	
	public String atualizar() {
		
		try {
			
			colaboradorService.atualizar(getNovoNome(), getCpf());
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		
		reportarMensagemDeSucesso("Seus dados foram atualizados com sucesso!");
		
		return EnderecoDasPaginasWEB.PAGINA_PRINCIPAL;
		
	}
	
	
	
	public boolean isEdicaoColaborador() { //Se nem o colaborador e nem o seu CPF forem nulos, significa que ele existe e que pode ser atualizado.
		
		return colaborador != null && colaborador.getCpf() != null;
	}
	
	
	
	public List<Colaborador> listarColaboradores() { //Lista apenas os colaboradores existentes.
		
		try {
			
			return colaboradorService.getColaboradores();
					
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
	}
	
	
	public List<ColaboradorComCafe> listarColaboradoresComCafe() { //Lista os colaboradores existentes e o que eles trouxeram .
		
		try {
			
			return colaboradorService.getColaboradoresESuasOpcoes();
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
	}
	
	
	public String excluirColaborador() { //Serve para deletar o colaborador.
		
		try {
			
			colaboradorService.deletar(getCpfRemover());
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		
		reportarMensagemDeSucesso("O colaborador foi excluído!");
		
		return EnderecoDasPaginasWEB.PAGINA_PRINCIPAL;
	}


	
	public ColaboradorService getColaboradorService() {
		return colaboradorService;
	}


	public void setColaboradorService(ColaboradorService colaboradorService) {
		this.colaboradorService = colaboradorService;
	}

	
	public Colaborador getColaborador() {
		return colaborador;
	}


	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	
	public String getNovoNome() {
		return novoNome;
	}


	public void setNovoNome(String novoNome) {
		this.novoNome = novoNome;
	}
	

	public CafeDaManha getCafe() {
		return cafe;
	}


	public void setCafe(CafeDaManha cafe) {
		this.cafe = cafe;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCpfRemover() {
		return cpfRemover;
	}


	public void setCpfRemover(String cpfRemover) {
		this.cpfRemover = cpfRemover;
	}
}
