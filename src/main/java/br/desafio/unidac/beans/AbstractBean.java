package br.desafio.unidac.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.desafio.unidac.utils.FormatarCPF;

public abstract class AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private FormatarCPF formatar = new FormatarCPF();
	
	
	protected void reportarMensagemDeErro(String detalhe) {
		
		reportarMensagem(true, detalhe, false);
	}
	

	protected void reportarMensagemDeSucesso(String detalhe) {
		
		reportarMensagem(false, detalhe, true);
	}
	
	
	private void reportarMensagem(boolean isErro, String detalhe, boolean keepMessages) {
		
		String sumario = "Sucesso!";
		Severity severity = FacesMessage.SEVERITY_INFO;
		
		if (isErro) {
			sumario = "Erro!";
			severity = FacesMessage.SEVERITY_ERROR;
			FacesContext.getCurrentInstance().validationFailed();
		} 

		FacesMessage msg = new FacesMessage(severity, sumario, detalhe);

		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.setKeepMessages(keepMessages);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	public String formatarCPF(String cpf) {  
		
		 return formatar.cpfFormatter(cpf);
   }
}
