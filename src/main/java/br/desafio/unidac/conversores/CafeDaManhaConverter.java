package br.desafio.unidac.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.desafio.unidac.dominio.CafeDaManha;
import br.desafio.unidac.servicos.CafeDaManhaService;

@FacesConverter(forClass = CafeDaManha.class)
public class CafeDaManhaConverter implements Converter<CafeDaManha> {
	
	private CafeDaManhaService cafe = new CafeDaManhaService();

	@Override
	public CafeDaManha getAsObject(FacesContext context, UIComponent component, String value) {
		
		if (value == null || value.trim().isEmpty()) {
			return null;
		}

		try {
			String alimento = value;
			return cafe.buscarPorNome(alimento);
			
			
		} catch (NumberFormatException e) {
			String msgErroStr = String.format("Erro de converão! Não foi possível realizar a conversão da string '%s' para o tipo esperado.", value);
			FacesMessage msgErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			throw new ConverterException(msgErro);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, CafeDaManha value) {
		
		if(!(value instanceof CafeDaManha)) return null;
		
		String alimento = value.getAlimento();
		
		return (alimento != null) ? alimento : null;
	}
}
