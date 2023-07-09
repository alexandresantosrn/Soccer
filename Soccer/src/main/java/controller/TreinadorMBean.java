package controller;

import java.util.Scanner;

import dao.TreinadorDAO;
import model.Treinador;

public class TreinadorMBean {

	private static Scanner input;

	public static void consultarTreinador() {

		input = new Scanner(System.in);

		System.out.print("Informe o nome do treinador: ");
		String nome = input.nextLine();
		System.out.print("Informe a equipe do treinador: ");
		String equipe = input.nextLine();

		realizarConsultaTreinador(nome, equipe);
	}

	private static void realizarConsultaTreinador(String nome, String equipe) {

		Treinador treinador = new Treinador();
		TreinadorDAO treinadorDAO = new TreinadorDAO();

		treinador = treinadorDAO.getTreinadorByNomeTime(nome, equipe);

		if (treinador != null) {
			System.out.println("Dados localizados com sucesso.");
			System.out.println("Nome do Treinador: " + treinador.getNome());
			System.out.println("Equipe Atual: " + treinador.getTimeAtual());
			System.out.println(" \n");
		}

		else {
			System.out.println("Não foram encontrados treinadores com nome e equipe informadas.");
		}
	}
}
