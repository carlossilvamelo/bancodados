package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bancodados.dominio.StatusTrabalho;
import com.bancodados.dominio.Trabalho;

public class TrabalhoDao {

	public void inserirTrabalho(Trabalho trabalho) {

		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		// operação 1
		String inserirTrabalho = "insert into trabalho (titulo_tra, status_tra, numero_curtidas_tra, resumo_tra)"
				+ "values(?,?,?,?) ";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(inserirTrabalho);

			stmt.setString(1, trabalho.getTitulo());
			stmt.setString(2, trabalho.getStatus().toString());
			stmt.setInt(3, trabalho.getCurtidas());
			stmt.setString(4, trabalho.getResumo());
			stmt.execute();
			stmt.close();
			
			

			System.out.println("Trabalho inserido!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// operação 2
		String buscarId = "select * from trabalho where titulo_tra = ? and status_tra = ? and numero_curtidas_tra = ? and"
				+ " resumo_tra = ?";

		try {
			stmt = ConnectionManager.getConnection().prepareStatement(buscarId);

			stmt.setString(1, trabalho.getTitulo());
			stmt.setString(2, trabalho.getStatus().toString());
			stmt.setInt(3, trabalho.getCurtidas());
			stmt.setString(4, trabalho.getResumo());
			stmt.execute();
			stmt.close();
			
			resultSet = stmt.getResultSet();
			
			while(resultSet.next()){
				trabalho.setIdTrabalho(resultSet.getInt("id_tra"));
			}

			System.out.println("id de trabalho atualizado!");
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Trabalho buscarTrabalhoPorTitulo(String titulo) {
		Trabalho trabalho = null;

		String sql = "select * from trabalho where titulo_tra = ?";

		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setString(1, titulo);

			// executa
			stmt.execute();

			ResultSet resultSet = stmt.getResultSet();
			while (resultSet.next()) {
				trabalho = new Trabalho();
				trabalho.setIdTrabalho(resultSet.getInt("id_tra"));
				trabalho.setResumo(resultSet.getString("resumo_tra"));
				trabalho.setStatus(StatusTrabalho.getStatusByNome(resultSet.getString("status_tra")));
				trabalho.setCurtidas(resultSet.getInt("numero_curtidas_tra"));
			}

			stmt.close();
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return trabalho;
	}

	public void atualizarTrabalho(Trabalho trabalho) {

		// operação 0

		PreparedStatement stmt = null;
		// operação 1
		String inserirUsuario = "UPDATE trabalho SET titulo_tra = ? and status_tra = ? and numero_curtidas_tra = ? and"
				+ " resumo_tra = ?"
				+ "WHERE id_tra = ?;";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(inserirUsuario);

			stmt.setString(1, trabalho.getTitulo());
			stmt.setString(2, trabalho.getStatus().toString());
			stmt.setInt(3, trabalho.getCurtidas());
			stmt.setString(4, trabalho.getResumo());
			stmt.setInt(5, trabalho.getIdTrabalho());
						stmt.execute();
			stmt.close();

			System.out.println("Trabalho atualizado!");
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
