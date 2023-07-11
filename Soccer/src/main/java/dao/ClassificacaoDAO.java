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
		String sql = "select * from Classificacao";
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