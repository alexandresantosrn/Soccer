package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Jogador;

public class JogadorDAO {

	public Jogador getJogadorByNomeTime(String nome, String equipe) {
		String sql = "SELECT j.Pessoa_idPessoa as idPessoa, p.nome AS nome_jogador, p.data_nascimento as data_nascimento, p.cpf as cpf, t.nome AS nome_equipe "
				+ "FROM Jogador j " + "INNER JOIN Pessoa p ON j.Pessoa_idPessoa = p.idPessoa "
				+ "INNER JOIN Jogador_joga_time jjt ON j.Pessoa_idPessoa = jjt.jogador_Pessoa_idPessoa "
				+ "INNER JOIN Time t ON jjt.Time_idTime = t.idTime " + "WHERE p.nome = ? " + "AND t.nome = ? "
				+ "AND jjt.data_fim is null";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, nome); // nome
			pstm.setString(2, equipe); // equipe

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {
				int idPessoa1 = resultSet.getInt("idPessoa");
				Date dataNascimento = resultSet.getDate("data_nascimento");
				String nomeJogador = resultSet.getString("nome_jogador");
				String nomeEquipe = resultSet.getString("nome_equipe");
				String cpf = resultSet.getString("cpf");

				Jogador jogador = new Jogador(idPessoa1, nomeJogador, nomeEquipe);
				jogador.setDataNascimento(dataNascimento);
				jogador.setCpf(cpf);

				return jogador;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void getHistoricoJogadorByNome(String nome) {

		String sql = "SELECT j.Pessoa_idPessoa as idPessoa, p.nome AS nome_jogador, t.nome AS nome_equipe, jjt.data_inicio as data_inicio, jjt.data_fim as data_fim "
				+ "FROM Jogador j " + "INNER JOIN Pessoa p ON j.Pessoa_idPessoa = p.idPessoa "
				+ "INNER JOIN Jogador_joga_time jjt ON j.Pessoa_idPessoa = jjt.jogador_Pessoa_idPessoa "
				+ "INNER JOIN Time t ON jjt.Time_idTime = t.idTime WHERE p.nome = ? " + "order by data_fim desc";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, nome); // nome

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {
				int idPessoa1 = resultSet.getInt("idPessoa");
				String nomeJogador = resultSet.getString("nome_jogador");
				String nomeEquipe = resultSet.getString("nome_equipe");
				Date dataInicio = resultSet.getDate("data_inicio");
				Date dataFim = resultSet.getDate("data_fim");

				if (dataFim != null) {
					System.out.println("Nome do Atleta: " + nomeJogador + " - " + "Equipe: " + nomeEquipe + " - "
							+ "Data Início: " + dataInicio + " - " + "Data Fim: " + dataFim + ".");
				}

				else {
					System.out.println("Nome do Atleta: " + nomeJogador + " - " + "Equipe: " + nomeEquipe + " - "
							+ "Data Início: " + dataInicio + " - " + "Data Fim: Indefinido" );
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Jogador getJogadorByCPFNome(String cpf, String nome) {
		String sql = "SELECT j.Pessoa_idPessoa as idPessoa, p.nome AS nome_jogador, p.cpf, p.data_nascimento AS data_nascimento "
				+ "FROM Jogador j " + "INNER JOIN Pessoa p ON j.Pessoa_idPessoa = p.idPessoa " + "WHERE cpf = ? "
				+ "AND p.nome = ?";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, cpf); // cpf
			pstm.setString(2, nome); // nome

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {
				int idPessoa1 = resultSet.getInt("idPessoa");
				String nomeJogador = resultSet.getString("nome_jogador");
				Date dataNascimento = resultSet.getDate("data_nascimento");

				Jogador jogador = new Jogador();
				jogador.setNome(nomeJogador);
				jogador.setDataNascimento(dataNascimento);
				jogador.setIdPessoa(idPessoa1);

				return jogador;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void atualizarJogador(int idPessoa, String name, String dataNascimento) {

		String sql = "update Pessoa " + "set nome = ?, data_nascimento = ? " + "where idPessoa = ?";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, name); // nome
			pstm.setString(2, dataNascimento); // data de nascimento
			pstm.setInt(3, idPessoa); // idPessoa

			pstm.executeUpdate();

			System.out.println("Dados atualizados com sucesso!");
			System.out.println("");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserirPessoaJogador(int idPessoa, String nome, String dataNascimento, String cpf) {

		String sql = "INSERT INTO Pessoa " + "(idPessoa, nome, data_nascimento, cpf) " + "VALUES(?, ?, ?, ?)";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setInt(1, idPessoa); // id
			pstm.setString(2, nome); // nome
			pstm.setString(3, dataNascimento); // data de nascimento
			pstm.setString(4, cpf); // idPessoa

			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserirJogador(int Pessoa_idPessoa, int numero) {

		String sql = "INSERT INTO Jogador " + "(Pessoa_idPessoa, numero_camisa) " + "VALUES(?, ?)";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setInt(1, Pessoa_idPessoa); // id
			pstm.setInt(2, numero); // numero

			pstm.executeUpdate();

			System.out.println("Dados inseridos com sucesso!");
			System.out.println("");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Integer getNextId() {

		String sql = "SELECT MAX(idPessoa) as IdPessoa FROM Pessoa";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {
				int idPessoa = resultSet.getInt("idPessoa");

				return idPessoa + 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
