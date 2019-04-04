package Controles;


import Entidades.Cliente;

public class ControladorCliente {
	private static ControladorCliente controler = null;
	
	private ControladorCliente() {
		
	}
	public static ControladorCliente getInstance() {
		if(controler == null) {
			return controler = new ControladorCliente();
		}
		return controler;
	}
	
	
	public boolean addCliente(String nome, String endereco, int contato, String cpf) {
		if(nome == null || nome.equals("") || nome.equals("     ") || !(nome.equals("[A-Za-z]")) || nome.equals("\n")) return false;
		if(endereco == null || endereco.equals("") || endereco.equals("   ")) return false;
		if(cpf.length() != 11) return false;
		if(!(nome.substring(0, 3).matches("[A-Z a-z]*")) )return false;
		
		Cliente cliente = new Cliente(nome, endereco, contato, cpf);
		if(RepositorioCliente.getInstance().addCliente(cliente)) {
			return true;
		}
		return false;
	}
	public boolean removerCliente(String cpf) {

		if(RepositorioCliente.getInstance().removerCliente(cpf)) {
			return true;
		}
		return false;
	}
	
	public boolean editarCliente(String cpf, String novoEndereco ) {
		if(RepositorioCliente.getInstance().editarCliente(cpf, novoEndereco)) {
			return true;
		}
		return false;
	}
	
	public Cliente buscarCliente(String cpf) {
		Cliente cliente = RepositorioCliente.getInstance().buscarCliente(cpf);
		return cliente;
	}
	
}	





















