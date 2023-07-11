package controller;

import java.util.Scanner;

import dao.ClassificacaoDAO;
import dao.TimeDAO;
import model.Time;

public class TimeMBean {

	private static Scanner input;

	public static void consultarTime() {

		input = new Scanner(System.in);

		System.out.print("Informe o nome da equipe: ");
		String equipe = input.nextLine();

		realizarConsultaEquipe(equipe);
	}

	private static void realizarConsultaEquipe(String equipe) {

		Time time = new Time();
		TimeDAO timeDAO = new TimeDAO();

		time = timeDAO.getTimeByNome(equipe);

		if (time != null) {
			System.out.println("Dados localizados com sucesso.");
			System.out.println("Nome da Equipe: " + time.getNome());
			System.out.println(" \n");
		}

		else {
			System.out.println("Não foram localizadas equipes com o nome informado.");
		}
	}

	public static void jogadoresPorTime() {
		input = new Scanner(System.in);

		System.out.print("Informe o nome da equipe: ");
		String equipe = input.nextLine();

		realizarConsultaJogadoresPorEquipe(equipe);
	}

	private static void realizarConsultaJogadoresPorEquipe(String equipe) {

		Time time = new Time();
		TimeDAO timeDAO = new TimeDAO();

		time = timeDAO.getTimeByNome(equipe);

		if (time != null) {
			timeDAO.getJogadoresByTime(equipe);
		}

		else {
			System.out.println("Não foram localizadas equipes com o nome informado.");
		}

	}

}
