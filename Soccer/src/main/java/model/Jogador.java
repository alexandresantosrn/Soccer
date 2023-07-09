package model;

public class Jogador extends Pessoa {

	int num_camisa;
	String timeAtual;

	public Jogador() {

	}

	public Jogador(int idPessoa, String nomeJogador, String timeAtual) {
		this.idPessoa = idPessoa;
		this.nome = nomeJogador;
		this.timeAtual = timeAtual;
	}

	public int getNum_camisa() {
		return num_camisa;
	}

	public void setNum_camisa(int num_camisa) {
		this.num_camisa = num_camisa;
	}

	public String getTimeAtual() {
		return timeAtual;
	}

	public void setTimeAtual(String timeAtual) {
		this.timeAtual = timeAtual;
	}

}
