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
			System.out.println("Data de Nascimento: " + jogador.getDataNascimento());
			System.out.println("CPF: " + jogador.getCpf());
			System.out.println("Equipe Atual: " + jogador.getTimeAtual());
			System.out.println("");
		}

		else {
			System.out.println("Não foram encontrados atletas com nome e equipe informadas.");
		}
	}

	public static void consultaHistoricoJogador() {

		input = new Scanner(System.in);

		System.out.print("Informe o nome do jogador: ");
		String nome = input.nextLine();
		realizarConsultaHistoricoAtleta(nome);
		System.out.println("");
	}

	private static void realizarConsultaHistoricoAtleta(String nome) {

		JogadorDAO jogadorDAO = new JogadorDAO();
		jogadorDAO.getHistoricoJogadorByNome(nome);
	}

	public static void atualizarJogador() {

		input = new Scanner(System.in);

		System.out.print("Informe o nome do jogador: ");
		String nome = input.nextLine();

		System.out.print("Informe o cpf do jogador: ");
		String cpf = input.nextLine();

		atualizarAtletaPeloCPF(nome, cpf);
	}

	private static void atualizarAtletaPeloCPF(String nome, String cpf) {

		Jogador jogador = new Jogador();
		JogadorDAO jogadorDAO = new JogadorDAO();

		jogador = jogadorDAO.getJogadorByCPFNome(cpf, nome);

		if (jogador != null) {
			System.out.println("Dados localizados com sucesso.");
			System.out.println("Nome do Jogador: " + jogador.getNome());
			System.out.println("Data de Nascimento: " + jogador.getDataNascimento());
			System.out.print("Informe um novo nome para o atleta: ");
			String name = input.nextLine();
			System.out.print("Informe uma nova data de nascimento para o atleta (Formato: AAAA-MM-DD): ");
			String dataNascimento = input.nextLine();

			JogadorDAO.atualizarJogador(jogador.getIdPessoa(), name, dataNascimento);
		}

		else {
			System.out.println("Não foram encontrados atletas com o cpf informado.");
		}
	}

	public static void cadastrarJogador() {

		input = new Scanner(System.in);

		System.out.print("Informe o nome do jogador: ");
		String nome = input.nextLine();
		System.out.print("Informe a data de nascimento do jogador (Formato: AAAA-MM-DD): ");
		String dataNascimento = input.nextLine();
		System.out.print("Informe o cpf do jogador: ");
		String cpf = input.next();
		System.out.print("Informe o número da camisa do jogador: ");
		int numero = input.nextInt();

		Jogador jogador = new Jogador();
		JogadorDAO jogadorDAO = new JogadorDAO();

		int idPessoa = jogadorDAO.getNextId();

		if (idPessoa > 0) {
			jogadorDAO.inserirPessoaJogador(idPessoa, nome, dataNascimento, cpf);
			jogadorDAO.inserirJogador(idPessoa, numero);
		}
		
	}
}
