package br.desafio.unidac.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.desafio.unidac.dominio.CafeDaManha;
import br.desafio.unidac.servicos.CafeDaManhaService;

@Named
@ViewScoped
public class CafeBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CafeDaManhaService cafeService = new CafeDaManhaService();
	
	private CafeDaManha cafe;
	private CafeDaManha cafeEscolhido;
	
	private String novoAlimento; //Para atualizar o alimento que já existe
	private String alimentoAntigo; //Para identificar o alimento que deve ser atualizado
	private String alimentoRemover; //Para identificar o alimento que deve ser removido
	private String cpf; //Para saber se o alimento pode ou nao ser excluido.
	
	public void iniciar() {
		
		try {
			
			if(cafe == null) { //Aqui estou criando um novo Cafe que sera uma possivel outra opcao que o colaborador vai levar.
				
				cafe = new CafeDaManha();
			} 
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
		}
	}
	
	
	
	public String salvar() {
		
		try {
				
			cafeService.salvar(cafe);
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		
		reportarMensagemDeSucesso("Obrigado(a) por contribuir com mais uma opção para o nosso café da manhã!");
		
		return EnderecoDasPaginasWEB.PAGINA_PRINCIPAL;
	}
	
	
	public String atualizar() {
		
		try {
			
			cafeService.atualizar(getAlimentoAntigo(), getNovoAlimento());
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		
		reportarMensagemDeSucesso("As opções do café da manhã foram atualizadas!");
		
		return EnderecoDasPaginasWEB.PAGINA_PRINCIPAL;
	}
	
	
	
	public boolean isEdicaCafe() {
		
		return cafe != null && cafe.getAlimento() != null;
	}
	
	
	
	public List<CafeDaManha> listarOpcoesDoCafe() { //Listar apenas as opcoes de cafe da manha
		
		try {
			
			return cafeService.getOpcoes();
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
	}
	
	
	
	public String excluirOpcao() {
		
		try {
			
			if(cafeService.podeExcluirAlimento(getCpf())) {
				
				cafeService.deletar(getAlimentoRemover(), getCpf());
				
				reportarMensagemDeSucesso("A opção de café da manhã " + getAlimentoRemover() + " foi excluída!");
				
			} else {
				
				reportarMensagemDeErro("Não foi possível excluir esta opção de café, pois ela é a única opção associada com o CPF: " + formatarCPF(getCpf()));
			}
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		
		return EnderecoDasPaginasWEB.PAGINA_PRINCIPAL;
	}


	public CafeDaManhaService getCafeService() {
		return cafeService;
	}


	public void setCafeService(CafeDaManhaService cafeService) {
		this.cafeService = cafeService;
	}


	public CafeDaManha getCafe() {
		return cafe;
	}


	public void setCafe(CafeDaManha cafe) {
		this.cafe = cafe;
	}


	public CafeDaManha getCafeEscolhido() {
		return cafeEscolhido;
	}


	public void setCafeEscolhido(CafeDaManha cafeEscolhido) {
		this.cafeEscolhido = cafeEscolhido;
	}


	public String getNovoAlimento() {
		return novoAlimento;
	}


	public void setNovoAlimento(String novoAlimento) {
		this.novoAlimento = novoAlimento;
	}


	public String getAlimentoAntigo() {
		return alimentoAntigo;
	}


	public void setAlimentoAntigo(String alimentoAntigo) {
		this.alimentoAntigo = alimentoAntigo;
	}


	public String getAlimentoRemover() {
		return alimentoRemover;
	}


	public void setAlimentoRemover(String alimentoRemover) {
		this.alimentoRemover = alimentoRemover;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
