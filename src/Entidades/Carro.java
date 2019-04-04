package Entidades;

public class Carro {
	private String modelo;
	private String placa ;
	private String cor;
	private int ano;
	private float precoAluguel;
	private boolean alugado;
	public Carro() {
		
	}

	public Carro(String modelo, String placa, String cor, int ano, float precoAluguel) {
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.precoAluguel = precoAluguel;
		this.alugado = false;
	}
	

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public float getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(float precoAluguel) {
		this.precoAluguel = precoAluguel;
	}
	
	
	
}
