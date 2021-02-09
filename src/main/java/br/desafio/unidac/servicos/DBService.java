package br.desafio.unidac.servicos;

import br.desafio.unidac.servicos.exception.CPFInvalidoException;

public class DBService {
	
//	private ColaboradorRepository coladDatabase = new ColaboradorInDataBase();
//	private CafeDaManhaRepository cafeDatabase = new CafeDaManhaInDataBase();
	
	
	public void instaciarDataBase() throws CPFInvalidoException {
		
//		Colaborador colab1 = new Colaborador("Maria", "19329930027");
//		Colaborador colab2 = new Colaborador("Marcos", "19329930028");
//		Colaborador colab3 = new Colaborador("Mario", "19329930029");
//		Colaborador colab4 = new Colaborador("Márcio", "19329930030");
//		Colaborador colab5 = new Colaborador("Ana", "19329930031");
//		Colaborador colab6 = new Colaborador("Junior", "19329930033");
//		
//		CafeDaManha cafe1 = new CafeDaManha("Bolo de Chocolate", colab1.getCpf());
//		CafeDaManha cafe2 = new CafeDaManha("Presunto", colab2.getCpf());
//		CafeDaManha cafe3 = new CafeDaManha("Pães", colab3.getCpf());
//		CafeDaManha cafe4 = new CafeDaManha("Suco de Laranja", colab4.getCpf());
//		CafeDaManha cafe5 = new CafeDaManha("Presunto", colab6.getCpf());
//		CafeDaManha cafe6 = new CafeDaManha("Requeijão", colab6.getCpf());
//		
//		coladDatabase.save(colab1, cafe1);
//		coladDatabase.save(colab2, cafe2);
//		coladDatabase.save(colab3, cafe3);
//		coladDatabase.save(colab4, cafe4);
//		coladDatabase.save(colab5, cafe5);
//		coladDatabase.save(colab6, cafe6);
//		
//		cafeDatabase.save(cafe1);
//		cafeDatabase.save(cafe2);
//		cafeDatabase.save(cafe3);
//		cafeDatabase.save(cafe4);
//		cafeDatabase.save(cafe5);
		
//		coladDatabase.update("Junior Jr.", "19329930033");
		
//		cafeDatabase.save(new CafeDaManha("Bananas", "19329930033"));
		
//		cafeDatabase.delete("Bananas");
		
//		cafeDatabase.update("Frutas", "Maçãs");
		
//		coladDatabase.delete("05201315097");

		
//		for (Colaborador c : coladDatabase.findAll()) {
//			
//			for (CafeDaManha cafe : cafeDatabase.findAll()) {
//				
//				if(c.getCpf().equals(cafe.getColaboradorCpf())) {
//					
//					System.out.println("Colaborador: " + c.getNome() + ", CPF: " + c.getCpf() + " ===> " + cafe.getAlimento()+"\n");
//				}
//			}
//		}
		
//		for (Colaborador c : coladDatabase.findAll()) {
//			
//			System.out.println("Nome: " + c.getNome() + ", CPF: " + c.getCpf()+"\n");
//		}
//		
//		for (CafeDaManha cafe : cafeDatabase.findAll()) {
//			System.out.println("Alimento: " + cafe.getAlimento() + ", Colaborador: " + cafe.getColaboradorCpf()+"\n");
//		}
		
//		Colaborador c = coladDatabase.findByID(2);
//		
//		System.out.println("Nome: " + c.getNome() + ", CPF: " + c.getCpf());
		
//		cafeDatabase.delete("Bolo de Chocolate");
//		coladDatabase.delete("19329930027");
		
//		coladDatabase.update("John Cena", "19329930026");
		
//		cafeDatabase.update("Suco de Uva", "19329930026");
		
//		CafeDaManha cafe = cafeDatabase.findByNome("Suco de Uva");
//		
//		System.out.println("Alimento: " + cafe.getAlimento() + ", CPF do colaborador: " + cafe.getColaboradorCpf());
	}
}
