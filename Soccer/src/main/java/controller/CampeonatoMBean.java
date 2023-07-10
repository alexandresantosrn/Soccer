package controller;

import java.util.Scanner;

import dao.CampeonatoDAO;
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

		Double mediaGols = campeonatoDAO.getMediaGolsCampeonato(nome);

		if (mediaGols > 0 ) {
			System.out.println("Dados localizados com sucesso.");
			System.out.println("Nome do Campeonato: " + campeonato.getNome());		
			System.out.println("Média de Gols:" + mediaGols);
			System.out.println(" \n");
		}

		else {
			System.out.println("Não foram localizados campeonatos com a denominação informada.");
		}

	}
}
