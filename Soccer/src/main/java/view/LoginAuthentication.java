package view;

import java.util.Scanner;

import connection.ConnectionFactory;
import dao.OrganizadorDAO;

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

		OrganizadorDAO organizadorDAO = new OrganizadorDAO();

		organizadorDAO.getOrganizadorByLoginSenha(login, password);

	}

}
