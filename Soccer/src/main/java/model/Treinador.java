package model;

public class Treinador extends Pessoa {

	String timeAtual;

	public Treinador() {

	}

	public Treinador(int idPessoa, String nomeTreinador, String nomeEquipe) {
		this.idPessoa = idPessoa;
		this.nome = nomeTreinador;
		this.timeAtual = nomeEquipe;
	}

	public String getTimeAtual() {
		return timeAtual;
	}

	public void setTimeAtual(String timeAtual) {
		this.timeAtual = timeAtual;
	}

}
