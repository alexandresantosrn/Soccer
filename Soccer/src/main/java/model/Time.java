package model;

public class Time {

	int idTime;
	String nome;

	public Time() {

	}

	public Time(int idTime, String nome) {
		this.idTime = idTime;
		this.nome = nome;
	}

	public int getIdTime() {
		return idTime;
	}

	public void setIdTime(int idTime) {
		this.idTime = idTime;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
