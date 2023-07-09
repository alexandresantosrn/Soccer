package view;

import java.util.Scanner;

public class App {

	private static Scanner input;

	public static void exibirMenu() {

		int option = 100;
		input = new Scanner(System.in);

		while (option != 0) {
			System.out.println("Informe a opção desejada: ");
			System.out.println("1 - Consultar Jogador");
			System.out.println("2 - Consultar Treinador");
			System.out.println("3 - Consultar Time");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			option = input.nextInt();

			switch (option) {

			case 1:
				
				break;

			case 0:
				System.out.println(" \n" + "Até logo pessoal!!");
				break;

			default:
				break;
			}

		}

	}
}
