package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Organizador;

public class OrganizadorDAO {

	public Organizador getOrganizadorByLoginSenha(String login, String password) {

		String sql = "SELECT * FROM Organizador WHERE login = ? AND senha = ?";

		try {

			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

			// Definindo os valores dos parâmetros
			pstm.setString(1, login); // login
			pstm.setString(2, password); // senha

			// Executando o comando SQL
			ResultSet resultSet = pstm.executeQuery();

			// Iterando sobre os resultados da consulta
			while (resultSet.next()) {
				int idPessoa1 = resultSet.getInt("Pessoa_idPessoa");
				String login1 = resultSet.getString("login");
				String senha1 = resultSet.getString("senha");

				Organizador organizador = new Organizador(idPessoa1, login1, senha1);

				return organizador;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
