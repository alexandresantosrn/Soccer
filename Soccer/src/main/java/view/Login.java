package view;

import java.util.Scanner;

import controller.LoginAuthentication;

public class Login {

	private static Scanner input;

	public static void main(String[] args) {

		int option = 100;
		input = new Scanner(System.in);

		while (option != 0 && option != 1) {

			System.out.println("---------------------------------------------------------------");
			System.out.println("Bem vindo ao sistema Soccer. Informe abaixo seu login e senha.");
			System.out.println("Escolha a opção desejada: ");
			System.out.println("1 - Realizar Login");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			option = input.nextInt();

			switch (option) {

			case 1:
				LoginAuthentication.realizarLogin();
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
