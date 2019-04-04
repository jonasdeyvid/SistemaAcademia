package Controles;

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
		if(modelo ==  null)  throw new IllegalArgumentException("modelo não pode ser nulo ") ; // vi na internet não sei como funciona qqr coisa tira 
		if(placa ==  null)  throw new IllegalArgumentException("placa não pode ser nula");
		if(cor ==  null)  throw new IllegalArgumentException("cor não pode ser nula");
		if(ano > 2019) return false; // tem que melhorar isso aqui 
		if(precoAluguel <= 0) return false;
		
		Carro carro = new Carro(modelo, placa, cor, ano, precoAluguel);
		RepositorioCarro.getInstance().addCarro(carro);
		return true;
	}
	
	public boolean removerCarro(String placa) {
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
	
	
	
	
}
