package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Treinador;

public class TreinadorDAO {

	public Treinador getTreinadorByNomeTime(String nome, String equipe) {
		String sql = "SELECT tr.Pessoa_idPessoa as idPessoa, p.nome AS nome_treinador, t.nome AS nome_equipe, p.data_nascimento as data_nascimento, p.cpf as cpf  "
				+ "FROM Treinador tr " + "INNER JOIN Pessoa p ON tr.Pessoa_idPessoa = p.idPessoa "
				+ "INNER JOIN Treinador_treina_time ttt ON tr.Pessoa_idPessoa = ttt.Treinador_pessoa_idPessoa "
				+ "INNER JOIN Time t ON ttt.Time_idTime = t.idTime " + "WHERE p.nome = ? " + "AND t.nome = ? "
				+ "AND ttt.data_fim is null";

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
				String nomeTreinador = resultSet.getString("nome_treinador");
				String nomeEquipe = resultSet.getString("nome_equipe");
				Date dataNascimento = resultSet.getDate("data_nascimento");
				String cpf = resultSet.getString("nome_equipe");

				Treinador treinador = new Treinador(idPessoa1, nomeTreinador, nomeEquipe);
				treinador.setCpf(cpf);
				treinador.setDataNascimento(dataNascimento);

				return treinador;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
