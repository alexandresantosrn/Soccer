package dao;

import java.sql.Connection;
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

}
