package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Campeonato;
import model.Jogador;

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
}
