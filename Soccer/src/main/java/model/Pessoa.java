package model;

import java.sql.Date;

public class Pessoa {

	int idPessoa;
	String nome;
	Date dataNascimento;
	String cpf;

	public Pessoa() {

	}

	public Pessoa(int idPessoa, String nome, Date dataNascimento, String cpf) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento2) {
		this.dataNascimento = dataNascimento2;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
