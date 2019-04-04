package Fronteiras;

import java.util.Scanner;

public class TelaInicial {
	
	public static void main(String[] args) {
		boolean parar = false;
		int escolha;
		Scanner input = new Scanner(System.in);
		while(!parar) {
			System.out.println(" [1] Cadastrar Cliente \n [2] Remover Cliente \n [3] Editar Cliente \n "
					+ "[4] Buscar Cliente \n [5] Cadastrar Carro \n [6] Editar Carro \n [7] Buscar Carro \n"
					+ " [8] Mostrar Carros Disponiveis");
			escolha = input.nextInt();
			switch(escolha) {
			case 1:
				TelaCadastrarCliente.mostrar();
				break;
			case 2:
				
				break;
				
			case 3: 
				
				break;
				
			case 4:
				
				break;
				
			case 5:
				
				break;
				
			case 6:
			
				break;
				
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;
			case 11:
				parar = true;
				break;
			default:
				
			}
			
				
		}
	}
}
