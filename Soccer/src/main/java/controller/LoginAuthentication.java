package controller;

import java.util.Scanner;

import dao.OrganizadorDAO;
import model.Organizador;
import view.App;

public class LoginAuthentication {

	private static Scanner input;

	public static void realizarLogin() {

		input = new Scanner(System.in);

		System.out.print("Informe o login: ");
		String login = input.nextLine();
		System.out.print("Informe a senha: ");
		String password = input.nextLine();

		autenticar(login, password);
	}

	private static void autenticar(String login, String password) {

		Organizador organizador = new Organizador();
		OrganizadorDAO organizadorDAO = new OrganizadorDAO();

		organizador = organizadorDAO.getOrganizadorByLoginSenha(login, password);

		if (organizador != null) {
			System.out.println("Usuário: " + organizador.getLogin() + " autenticado com sucesso!");
			System.out.println("");
			App.exibirMenu();
		}

		else {
			System.out.println("Login ou Senha inválidos!");
			System.out.println("Informe novamente os dados para autenticação.");
			realizarLogin();
		}
	}

}
