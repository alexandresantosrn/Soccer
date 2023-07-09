package controller;

import java.util.Scanner;

public class JogadorMBean {

	private static Scanner input;

	public static void consultarJogador() {

		input = new Scanner(System.in);

		System.out.print("Informe o nome do jogador: ");
		String nome = input.nextLine();
		System.out.print("Informe a equipe do jogador: ");
		String equipe = input.nextLine();

		realizarConsultaAtleta(nome, equipe);
	}

	private static void realizarConsultaAtleta(String nome, String equipe) {
		
		
	}
}
