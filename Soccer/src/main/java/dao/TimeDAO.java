package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Time;

public class TimeDAO {

	public Time getTimeByNome(String equipe) {

		String sql = "SELECT * FROM Time WHERE nome = ?";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, equipe); // nome da equipe

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {
				int idTime1 = resultSet.getInt("idTime");
				String nomeEquipe = resultSet.getString("nome");

				Time time = new Time(idTime1, nomeEquipe);

				return time;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void getJogadoresByTime(String equipe) {

		String sql = "SELECT j.Pessoa_idPessoa as idPessoa, p.nome AS nome_jogador, t.nome AS nome_equipe, jjt.data_inicio, jjt.data_fim "
				+ "FROM Jogador j "
				+ "INNER JOIN Pessoa p ON j.Pessoa_idPessoa = p.idPessoa "
				+ "INNER JOIN Jogador_joga_time jjt ON j.Pessoa_idPessoa = jjt.jogador_Pessoa_idPessoa "
				+ "INNER JOIN Time t ON jjt.Time_idTime = t.idTime WHERE t.nome = ? "
				+ "and jjt.data_fim is null"; 

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, equipe); // nome

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {
				int idPessoa1 = resultSet.getInt("idPessoa");
				String nomeJogador = resultSet.getString("nome_jogador");
				String nomeEquipe = resultSet.getString("nome_equipe");
				Date dataInicio = resultSet.getDate("data_inicio");				

				System.out.println("Nome do Atleta: " + nomeJogador + " - " + "Equipe: " + nomeEquipe + " - "
						+ "Data Início: " + dataInicio);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
