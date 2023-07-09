package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Jogador;

public class JogadorDAO {

	public Jogador getJogadorByNomeTime(String nome, String equipe) {
		String sql = "SELECT j.idPessoa, p.nome AS nome_jogador, t.nome AS nome_equipe " + "FROM Jogador j "
				+ "INNER JOIN Pessoa p ON j.idPessoa = p.idPessoa "
				+ "INNER JOIN Jogador_joga_time jjt ON j.idPessoa = jjt.idPessoa "
				+ "INNER JOIN Time t ON jjt.idTime = t.idTime " + "WHERE p.nome = ? " + "AND t.nome = ? "
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
				String nomeJogador = resultSet.getString("nome_jogador");
				String nomeEquipe = resultSet.getString("nome_equipe");

				Jogador jogador = new Jogador(idPessoa1, nomeJogador, nomeEquipe);

				return jogador;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
