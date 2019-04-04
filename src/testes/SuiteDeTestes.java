package testes;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controles.ControladorCliente;

class SuiteDeTestes {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	//testes de cliente
	public void testaAdicaoDeCliente() {
		String nome = "joao";
		String endereco = "Quixada, CE";
		int contato = 92054322;
		String cpf = "12345612311";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		
		assertEquals(true, retorno);
	}

}
