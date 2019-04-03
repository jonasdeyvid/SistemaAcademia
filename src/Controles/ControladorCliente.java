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
		RepositorioCliente repositorio = null;
		if(repositorio.getInstance().addCliente(cliente)) {
			return true;
		}
		return false;
	}
	
}	
