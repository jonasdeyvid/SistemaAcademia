package testes;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controles.ControladorCliente;
import Entidades.Cliente;

class SuiteDeTestes {

	
	//testes de cliente
	//adicao
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

	//busca
	@Test
	public void buscarClienteCpfValido(){
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", "Quixada, CE", 12345678, cpfCliente);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals("joao", c.getNome());
	}
	
	@Test
	public void buscarClienteCpfNulo() {
		Cliente c = ControladorCliente.getInstance().buscarCliente(null);
		assertEquals(null, c);
	}
	
	@Test
	public void buscarClienteCpfVazio() {
		Cliente c = ControladorCliente.getInstance().buscarCliente("");
		assertEquals(null, c);
	}
	
	@Test
	public void buscarClienteCaracteresEspeciais() {
		Cliente c = ControladorCliente.getInstance().buscarCliente("@Çç#_  _+-\\n");
		assertEquals(null, c);
	}
	
	//remocao
	@Test
	public void removerClienteCpfValido() {
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", "Quixada, CE", 12345678, cpfCliente);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals("joao", c.getNome());
		boolean retorno = ControladorCliente.getInstance().removerCliente(cpfCliente);
		assertEquals(true, retorno);
		retorno = ControladorCliente.getInstance().removerCliente(cpfCliente);
		assertEquals(false, retorno);
	}
	
	@Test
	public void removerClienteCpfNulo() {
		boolean retorno = ControladorCliente.getInstance().removerCliente(null);
		assertEquals(false, retorno);
	}
	
	@Test
	public void removerClienteCpfVazio() {
		boolean retorno = ControladorCliente.getInstance().removerCliente("");
		assertEquals(false, retorno);
	}
	
	@Test
	public void removerClienteCaracteresEspeciais() {
		boolean retorno = ControladorCliente.getInstance().removerCliente("@Çç#_  _+-\n");
		assertEquals(false, retorno);
	}
	
	//edicao
	@Test
	public void editarClienteValido() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", "Quixada, CE", 12345678, cpfCliente);
		ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(enderecoNovo, c.getEndereco());
	}
	
	@Test
	public void editarClienteCpfNulo() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = null;
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		assertEquals(false, retorno);
	}
	
	@Test
	public void editarClienteCpfVazio() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = "";
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		assertEquals(false, retorno);
	}
	
	@Test
	public void editarClienteCpfEspecial() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = "ç\n_-!@#$%¨";
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		assertEquals(false, retorno);
	}
	
	@Test
	public void editarClienteEnderecoValido() {
		String enderecoNovo = "Fortaleza, CE";
		String enderecoAntigo = "Quixada, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", enderecoAntigo, 12345678, cpfCliente);
		ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(enderecoNovo, c.getEndereco());
	}
	
	@Test
	public void editarClienteEnderecoNulo() {
		String enderecoNovo = null;
		String enderecoAntigo = "Quixada, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", enderecoAntigo, 12345678, cpfCliente);
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(false, retorno);
		assertEquals(enderecoAntigo, c.getEndereco());
	}
	
	@Test
	public void editarClienteEnderecoVazio() {
		String enderecoNovo = "";
		String enderecoAntigo = "Quixada, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", enderecoAntigo, 12345678, cpfCliente);
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(false, retorno);
		assertEquals(enderecoAntigo, c.getEndereco());
	}
	
	@Test
	public void editarClienteEnderecoEspecial() {
		String enderecoNovo = "ç\\n_-!@#$%¨";
		String enderecoAntigo = "Quixada, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", enderecoAntigo, 12345678, cpfCliente);
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(false, retorno);
		assertEquals(enderecoAntigo, c.getEndereco());
	}
}
