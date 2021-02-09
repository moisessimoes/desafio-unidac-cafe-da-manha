package br.desafio.unidac.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.desafio.unidac.dominio.Colaborador;
import br.desafio.unidac.servicos.ColaboradorService;

@FacesConverter(forClass = Colaborador.class)
public class ColaboradorConverter implements Converter<Colaborador> {
	
	private ColaboradorService colaborador = new ColaboradorService();

	@Override
	public Colaborador getAsObject(FacesContext context, UIComponent component, String value) {
		
		if (value == null || value.trim().isEmpty()) {
			return null;
		}

		try {
			int cpf = Integer.parseInt(value);
			return colaborador.buscarPorCPF(String.valueOf(cpf));
			
			
		} catch (NumberFormatException e) {
			String msgErroStr = String.format("Erro de converão! Não foi possível realizar a conversão da string '%s' para o tipo esperado.", value);
			FacesMessage msgErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			throw new ConverterException(msgErro);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Colaborador value) {
		
		if(!(value instanceof Colaborador)) return null;
		
		String cpf = value.getCpf();
		
		return (cpf != null) ? cpf : null;
	}
}
