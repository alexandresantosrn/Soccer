package controller;

import java.util.Scanner;

import dao.JogadorDAO;
import model.Jogador;

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

		Jogador jogador = new Jogador();
		JogadorDAO jogadorDAO = new JogadorDAO();

		jogador = jogadorDAO.getJogadorByNomeTime(nome, equipe);

		if (jogador != null) {
			System.out.println("Dados localizados com sucesso.");
			System.out.println("Nome do Jogador: " + jogador.getNome());
			System.out.println("Equipe Atual: " + jogador.getTimeAtual());
			System.out.println(" \n");
		}

		else {
			System.out.println("Não foram encontrados atletas com nome e equipe informadas.");
		}
	}
}
