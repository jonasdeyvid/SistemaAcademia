package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCarro;

public class TelaBuscarCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro que voc� deseja buscar: ");
		String placa = input.nextLine();
		
		if(ControladorCarro.getInstance().buscarCarro(placa) == null) {
			System.out.println("Carro n�o encontrado");
		}else {
			System.out.println(ControladorCarro.getInstance().buscarCarro(placa));
		}
	}
}
