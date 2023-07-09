package model;

public class Jogador extends Pessoa {

	int num_camisa;

	public Jogador() {

	}

	public Jogador(int idPessoa, int num_camisa) {
		this.idPessoa = idPessoa;
		this.num_camisa = num_camisa;
	}

	public int getNum_camisa() {
		return num_camisa;
	}

	public void setNum_camisa(int num_camisa) {
		this.num_camisa = num_camisa;
	}

}
