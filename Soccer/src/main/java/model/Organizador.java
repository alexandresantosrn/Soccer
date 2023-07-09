package model;

public class Organizador extends Pessoa {

	String login;
	String senha;

	public Organizador() {

	}

	public Organizador(int idPessoa, String login, String senha) {
		this.idPessoa = idPessoa;
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
