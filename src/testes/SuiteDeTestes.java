package testes;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controles.ControladorCliente;

class SuiteDeTestes {

	
	//testes de cliente
	@Test
	public void testaAdicaoDeCliente() {
		String nome = "joao";
		String endereco = "Quixada CE";
		int contato = 92054322;
		String cpf = "12345612311";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(true, retorno);
	}

	@Test
	public void adicionarClienteComNomeNulo() {
		String nome = null;
		String endereco = "Quixada, CE";
		int contato = 92054322;
		String cpf = "12345612312";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}

	@Test
	public void adicionarClienteComNomeVazio() {
		String nome = "";
		String endereco = "Quixada, CE";
		int contato = 92054322;
		String cpf = "12345612313";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComNomeDeEspacos() {
		String nome = "     ";
		String endereco = "Quixada, CE";
		int contato = 92054322;
		String cpf = "12345612314";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoNulo() {
		String nome = "joao";
		String endereco = null;
		int contato = 92054322;
		String cpf = "12345612315";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoVazio() {
		String nome = "joao";
		String endereco = "";
		int contato = 92054322;
		String cpf = "12345612316";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoComEspeciais() {
		String nome = "joao";
		String endereco = "@-ç";
		int contato = 92054322;
		String cpf = "12345612317";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoComBarraN() {
		String nome = "joao";
		String endereco = "\n";
		int contato = 92054322;
		String cpf = "12345612318";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComContatoDeUmDigito() {
		String nome = "joao";
		String endereco = "Quixada, CE";
		int contato = 9;
		String cpf = "12345612319";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
}
