package Controles;

import java.util.ArrayList;
import java.util.List;

import Entidades.Cliente;

public class RepositorioCliente {
	private static RepositorioCliente repositorio = null;
	private List<Cliente> clientes;
	
	private RepositorioCliente() {
		clientes = new ArrayList<Cliente>();
	}
	
	public RepositorioCliente getInstance() {
		if(repositorio == null) {
			return repositorio = new RepositorioCliente();
		}
		return repositorio;
	}
	
	
	public boolean addCliente(Cliente client) {
		for (Cliente cliente : clientes) {
			if(cliente.getCpf() == client.getCpf()) {
				return false;
			}
		}
		clientes.add(client);
		return true;

	}
	
}
