package Controles;

import com.sun.security.ntlm.Client;

import Entidades.Cliente;

public class ControladorCliente {
	private static ControladorCliente controler = null;
	
	private ControladorCliente() {
		
	}
	public ControladorCliente getInstance() {
		if(controler == null) {
			return controler = new ControladorCliente();
		}
		return controler;
	}
	
	
	public boolean addCliente(String nome, String endereco, int contato, int cpf) {
		Cliente cliente = new Cliente(nome, endereco, contato, cpf);
		if(RepositorioCliente.getInstance().addCliente(cliente)) {
			return true;
		}
		return false;
	}
	public boolean removerCliente(int cpf) {

		if(RepositorioCliente.getInstance().removerCliente(cpf)) {
			return true;
		}
		return false;
	}
	
	public boolean editarCliente(int cpf, String novoEndereco ) {
		if(RepositorioCliente.getInstance().editarCliente(cpf, novoEndereco)) {
			return true;
		}
		return false;
	}
	
	public Cliente buscarCliente(int cpf) {
		Cliente cliente = RepositorioCliente.getInstance().buscarCliente(cpf);
		if(cliente == null) {
			
		}
		return cliente;
	}
	
}	





















