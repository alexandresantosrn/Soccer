package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Classificacao;

public class ClassificacaoDAO {
	
	public static List<Classificacao> getClassificacao() {
		//String sql = "select * from Classificacao";
		int campeonatoId = 1; // Substitua pelo ID do campeonato desejado

		String sql = "SELECT t.idTime, t.nome AS Time, " +
	             "COALESCE(SUM(CASE WHEN dp.Time_idTimeCasa = t.idTime THEN " +
	             "CASE WHEN dp.golsCasa > dp.golsVisitante THEN 3 " +
	             "WHEN dp.golsCasa = dp.golsVisitante THEN 1 " +
	             "ELSE 0 END " +
	             "ELSE " +
	             "CASE WHEN dp.golsCasa < dp.golsVisitante THEN 3 " +
	             "WHEN dp.golsCasa = dp.golsVisitante THEN 1 " +
	             "ELSE 0 END " +
	             "END), 0) AS Pontos, " +
	             "COALESCE(SUM(CASE WHEN dp.Time_idTimeCasa = t.idTime THEN dp.golsCasa ELSE dp.golsVisitante END), 0) AS GolsMarcados, " +
	             "COALESCE(SUM(CASE WHEN dp.Time_idTimeCasa = t.idTime THEN dp.golsVisitante ELSE dp.golsCasa END), 0) AS GolsSofridos " +
	             "FROM Time t " +
	             "LEFT JOIN Detalhes_Partida dp ON dp.Time_idTimeCasa = t.idTime OR dp.Time_idTimeVisitante = t.idTime " +
	             "LEFT JOIN Partida p ON dp.Partida_idPartida = p.idPartida " +
	             "LEFT JOIN Rodada r ON p.Rodada_idRodada = r.idRodada " +
	             "LEFT JOIN Campeonato c ON r.Campeonato_idCampeonato = c.idCampeonato " +
	             "WHERE c.idCampeonato = "+campeonatoId+ " "+
	             "GROUP BY t.idTime, t.nome " +
	             "ORDER BY Pontos DESC, GolsMarcados DESC";

		 
		
		
		List<Classificacao> classificacao = new ArrayList();
		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);


			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			
			while (resultSet.next()) {
				int pontos = resultSet.getInt("Pontos");
				String time = resultSet.getString("Time");
				int golsC = resultSet.getInt("GolsSofridos");
				int golsP = resultSet.getInt("GolsMarcados");
				
				Classificacao c = new Classificacao(time, pontos, golsP, golsC);
				classificacao.add(c);
				System.out.println("time: " + time + " -- " + "pontos: " + pontos + " -- " + "gols Pro: " +  golsP + " -- " + "Gols Cont: " + golsC);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classificacao;
	}
	
	
	
}