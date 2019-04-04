package Controles;

import java.util.List;

import Entidades.Carro;

public class RepositorioCarro {
	private static RepositorioCarro repositorio;
	private List<Carro> carros;
	
	private RepositorioCarro() {
		
	}
	public static RepositorioCarro getInstance() {
		if(repositorio == null) {
			return repositorio = new RepositorioCarro();
		}
		return repositorio;
	}
	
	public boolean addCarro(Carro carro) {
		if(buscarCarro(carro.getPlaca()) == null ) {
			carros.add(carro);
			return true;
		}
		return  false;
	}
	
	public boolean removerCarro(String placa) {
		if(buscarCarro(placa) == null) {
			return false;
		}
		carros.remove(buscarCarro(placa));
		return true;
	}

	public Carro buscarCarro(String placa) {
		for (Carro carro : carros) {
			if(carro.getPlaca().equals(placa)) {
				return carro;
			}
		}
		return null;
	}
	
	public boolean editarPrecoCarro(String placa, float novoPreco) {
		if(buscarCarro(placa) == null) {
			return false;
		}
		buscarCarro(placa).setPrecoAluguel(novoPreco);
		return true;
	}
}








