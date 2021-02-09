package br.desafio.unidac.beans;

public class EnderecoDasPaginasWEB {
	
	
	public EnderecoDasPaginasWEB() {
		
		throw new UnsupportedOperationException("Esta classe não deve ser instanciada!");
	}
	
	
	private static final String REDIRECT_TRUE = "?faces-redirect=true";
	
	public static final String PAGINA_PRINCIPAL = "/index.xhtml" + REDIRECT_TRUE;
	
	public static final String PAGINA_CADASTRAR_COLABORADOR = "/paginas/cadastrarColaborador.xhtml" + REDIRECT_TRUE;
	
	public static final String PAGINA_CADASTRAR_OPCAO = "/paginas/cadastrarOpcao.xhtml" + REDIRECT_TRUE;
	
	public static final String PAGINA_LISTAR_COLABORADORES = "/paginas/listarColaboradores.xhtml" + REDIRECT_TRUE;
	
	public static final String PAGINA_LISTAR_OPCOES = "/paginas/listarOpcoes.xhtml" + REDIRECT_TRUE;

}
