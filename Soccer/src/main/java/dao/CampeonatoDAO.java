package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;

public class CampeonatoDAO {

	public Double getMediaGolsCampeonato(String nome) {
		String sql = "SELECT AVG(total_gols) as media " + "FROM ( "
				+ "SELECT SUM(golsCasa + golsVisitante) as total_gols " + "FROM Detalhes_Partida dp "
				+ "INNER JOIN Partida p ON dp.Partida_idPartida = p.idPartida "
				+ "INNER JOIN Rodada r ON p.idPartida = r.idRodada "
				+ "INNER JOIN Campeonato c ON r.Campeonato_idCampeonato = c.idCampeonato " + "WHERE c.nome = ? "
				+ "GROUP BY Partida_idPartida " + ") subquery";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, nome); // nome

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {
				Double media = resultSet.getDouble("media");

				return media;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void getArtilheirosCampeonato(String nome) {
		String sql = "Select COUNT(p.nome) as qtd, p.nome as nome " + "from Pessoa p "
				+ "inner join Jogador j ON p.idPessoa = j.Pessoa_idPessoa "
				+ "inner join Gol g on j.Pessoa_idPessoa = g.Jogador_Pessoa_idPessoa "
				+ "inner join Partida p2 on g.Partida_idPartida = p2.idPartida "
				+ "inner join Rodada r on p2.Rodada_idRodada = r.idRodada "
				+ "inner join Campeonato c on r.Campeonato_idCampeonato = c.idCampeonato " + "where gol_contra = 0 "
				+ "and c.nome = ? " + "GROUP by p.nome " + "ORDER BY qtd desc";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, nome); // nome

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {
				int quantidade = resultSet.getInt("qtd");
				String nomeJogador = resultSet.getString("nome");

				System.out.println("Gols: " + quantidade + " - " + "Nome: " + nomeJogador);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Boolean existeCampeonatoByName(String nome) {

		String sql = "SELECT * FROM Campeonato WHERE nome = ?";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, nome); // nome

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {

				Boolean existe = true;
				return existe;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
