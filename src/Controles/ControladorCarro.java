package Controles;

import java.util.ArrayList;
import java.util.List;

import Entidades.Carro;

public class ControladorCarro {
	private static ControladorCarro controler;
	
	private ControladorCarro() {
		
	}
	
	public static ControladorCarro getInstance() {
		if(controler == null ) {
			return new ControladorCarro();
		}
		return controler;
	}
	
	public boolean addCarro(String modelo, String placa, String cor, int ano, float precoAluguel) {
		if(modelo ==  null || modelo.equals(""))  return false ; // vi na internet n�o sei como funciona qqr coisa tira 
		if(placa ==  null)  return false;
		if(cor ==  null)  return false;
		if(ano > 2019) return false; // tem que melhorar isso aqui 
		if(precoAluguel <= 0) return false;
		
		Carro carro = new Carro(modelo, placa, cor, ano, precoAluguel);
		RepositorioCarro.getInstance().addCarro(carro);
		return true;
	}
	
	public boolean removerCarro(String placa) {
		if(placa ==  null)  throw new IllegalArgumentException("placa nao pode ser nula");
		if(RepositorioCarro.getInstance().removerCarro(placa)) {
			return true;
		}
		return false;
	}
	
	public boolean editarPrecoCarro(String placa, float novoPreco) {
		if(RepositorioCarro.getInstance().editarPrecoCarro(placa, novoPreco)){
			return true;
		}
		return false;
	}
	
	public List<Carro> carrosDisponiveis(){
		return RepositorioCarro.getInstance().carrosDisponiveis();
	}
	public boolean alugarCarro(String placa) {
		for (Carro carro : RepositorioCarro.getInstance().carrosDisponiveis()) {
			if(carro.getPlaca().equals(placa)) {
				carro.setAlugado(true);
				return true;
			}
		}
		return false;
	}
	public boolean devolverCarro(String placa) {
		for (Carro carro : RepositorioCarro.getInstance().getCarros()) {
			if(carro.getPlaca().equals(placa)) {
				if(carro.isAlugado() == true) {
					carro.setAlugado(false);
					return true;
				}
			}
			
		}
		return false;
	}
	public Carro buscarCarro(String placa) {
		return RepositorioCarro.getInstance().buscarCarro(placa);
	}
	
	public List<Carro> getCarros(){
		return RepositorioCarro.getInstance().getCarros();
	}
	
	
}
