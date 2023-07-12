package controller;

import java.util.Scanner;

import dao.CampeonatoDAO;
import dao.ClassificacaoDAO;
import model.Campeonato;

public class CampeonatoMBean {

	private static Scanner input;

	public static void consultarMediaGols() {

		input = new Scanner(System.in);

		System.out.print("Informe o nome do campeonato: ");
		String nome = input.nextLine();

		realizarConsultaMediaGols(nome);
	}

	private static void realizarConsultaMediaGols(String nome) {

		Campeonato campeonato = new Campeonato();
		campeonato.setNome(nome);
		CampeonatoDAO campeonatoDAO = new CampeonatoDAO();

		if (campeonatoDAO.existeCampeonatoByName(nome) == null) {
			System.out.println("Não foram localizados campeonatos com a denominação informada.");
		}

		else {
			Double mediaGols = campeonatoDAO.getMediaGolsCampeonato(nome);
			System.out.println("Dados localizados com sucesso.");
			System.out.println("Nome do Campeonato: " + campeonato.getNome());
			System.out.println("Média de Gols: " + mediaGols);
			System.out.println("");
		}

	}

	public static void consultarArtilheiros() {

		input = new Scanner(System.in);

		System.out.print("Informe o nome do campeonato: ");
		String nome = input.nextLine();

		realizarConsultaArtilharia(nome);
	}

	private static void realizarConsultaArtilharia(String nome) {

		CampeonatoDAO campeonatoDAO = new CampeonatoDAO();

		if (campeonatoDAO.existeCampeonatoByName(nome) == null) {
			System.out.println("Não foram localizados campeonatos com a denominação informada.");
		}

		else {
			campeonatoDAO.getArtilheirosCampeonato(nome);
			System.out.println("");
		}

	}

	public static void consultarClassificacao() {

		input = new Scanner(System.in);

		System.out.print("Informe o nome do campeonato: ");
		String nome = input.nextLine();

		realizarConsultaClassificacao(nome);
	}

	private static void realizarConsultaClassificacao(String nome) {

		CampeonatoDAO campeonatoDAO = new CampeonatoDAO();

		if (campeonatoDAO.existeCampeonatoByName(nome) == null) {
			System.out.println("Não foram localizados campeonatos com a denominação informada.");
		}

		else {
			ClassificacaoDAO.getClassificacao(nome);
			System.out.println("");
		}

	}
}
