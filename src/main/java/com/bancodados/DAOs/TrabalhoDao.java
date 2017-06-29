package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bancodados.dominio.Discente;
import com.bancodados.dominio.StatusTrabalho;
import com.bancodados.dominio.Trabalho;

public class TrabalhoDao {

	public void inserirTrabalho(Trabalho trabalho, Discente discente) {

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

			while (resultSet.next()) {
				trabalho.setIdTrabalho(resultSet.getInt("id_tra"));
			}

			System.out.println("id de trabalho atualizado!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// operação 3
		String inserirParticipante = "insert into participante_trabalho (id_discente_par, id_trabalho_par)"
				+ "values(?,?) ";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(inserirParticipante);

			stmt.setInt(1, discente.getId());
			stmt.setInt(2, trabalho.getIdTrabalho());
			stmt.execute();
			stmt.close();

			System.out.println("usuário inserido na tabela participante_trabalho!");
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
				+ " resumo_tra = ?" + "WHERE id_tra = ?;";
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

		for (Discente participante : trabalho.getParticipantes()) {
			// operação 2
			String inserirParticipantes = "INSERT INTO participante_trabalho VALUES (?,?) ON DUPLICATE KEY UPDATE;";
			try {
				stmt = ConnectionManager.getConnection().prepareStatement(inserirParticipantes);

				stmt.setInt(1, participante.getId());
				stmt.setInt(2, trabalho.getIdTrabalho());
				stmt.execute();
				stmt.close();

				System.out.println("Trabalho atualizado!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try

		{
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserirParticipante(Trabalho trabalho, Discente discente) {
		PreparedStatement stmt = null;
		// operação 1
		String inserirParticipantes = "INSERT INTO participante_trabalho VALUES (?,?) ON DUPLICATE KEY UPDATE;";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(inserirParticipantes);

			stmt.setInt(1, discente.getId());
			stmt.setInt(2, trabalho.getIdTrabalho());
			stmt.execute();
			stmt.close();

			System.out.println("Participante inserido!");
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Trabalho> procurarTrabalhosPorDiscente(Discente discente){
		
		ArrayList<Trabalho> trabalhosEncontrados = new ArrayList<Trabalho>();
		Trabalho trabalho = null;
		//operação1
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String procurarIdTrabalhos = "SELECT (id_tra, titulo_tra, resumo_tra, status_tra, numero_curtidas_tra) FROM trabalho"
				+ "INNER JOIN(SELECT id_trabalho_par FROM participante_trabalho WHERE id_discente_par = ?) "
				+ "ON id_tra = id_trabalho_par;";
		try{
			stmt = ConnectionManager.getConnection().prepareStatement(procurarIdTrabalhos);
			
			stmt.setInt(1, discente.getId());
			stmt.execute();
			stmt.close();
			
			resultSet = stmt.getResultSet();
			
			while(resultSet.next()){
				trabalho = new Trabalho();
				trabalho.setIdTrabalho(resultSet.getInt("id_tra"));
				trabalho.setTitulo(resultSet.getString("titulo_tra"));
				trabalho.setResumo(resultSet.getString("resumo_tra"));
				trabalho.setStatus(StatusTrabalho.getStatusByNome(resultSet.getString("status_tra")));
				trabalho.setCurtidas(resultSet.getInt("numero_curtidas_tra"));
				trabalhosEncontrados.add(trabalho);
			}
			ConnectionManager.closeConnection();
			/* 
			PreparedStatement stmt1 = null;
			ResultSet resultSet1 = null;
			//operação 2
			String procurarTrabalhos = "SELECT * FROM trabalho WHERE id_tra = ?;";
			for(Trabalho trab_encontrado : trabalhosEncontrados){
				stmt1 = ConnectionManager.getConnection().prepareStatement(procurarTrabalhos);
				
				stmt1.setInt(1, trab_encontrado.getIdTrabalho());
				
				stmt1.execute();
				stmt1.close();
				
				resultSet1 = stmt1.getResultSet();
				while(resultSet1.next()){
					trab_encontrado.setTitulo(resultSet1.getString("titulo_tra"));
					trab_encontrado.setResumo(resultSet1.getString("resumo_tra"));
					trab_encontrado.setStatus(StatusTrabalho.getStatusByNome(resultSet1.getString("status_tra")));
					trab_encontrado.setCurtidas(resultSet1.getInt("numero_curtidas_tra"));
					break;
				}
			}
			*/
			ConnectionManager.closeConnection();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return trabalhosEncontrados;
	}
	
	public ArrayList<Discente> procurarDiscentesPorTrabalho(Trabalho trabalho){
		ArrayList<Discente> discentesEncontrados = new ArrayList<Discente>();
		Discente discente = null;
		DiscenteDao discentedao = new DiscenteDao();
		//operação1
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		int id;
		String procurarIdDiscentes = "SELECT id_discente_par from participante_trabalho where id_trabalho_par = ?;";
		try{
			stmt = ConnectionManager.getConnection().prepareStatement(procurarIdDiscentes);
			
			stmt.setInt(1, trabalho.getIdTrabalho());
			stmt.execute();
			stmt.close();
			
			resultSet = stmt.getResultSet();
			
			while(resultSet.next()){
				id = resultSet.getInt("id_discente_par");
				discente = discentedao.buscarDiscentePorId(id);
				discentesEncontrados.add(discente);
			}
			
			ConnectionManager.closeConnection();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return discentesEncontrados;
	}
	
	public ArrayList<Trabalho> procurarQuantidade(int quantidade){
		ArrayList<Trabalho> trabs_encontrados = new ArrayList<Trabalho>();
		Trabalho trabAtual = null;
		//operação1
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String procurarTrabalhosQuant = "SELECT * FROM trabalho LIMIT ?";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(procurarTrabalhosQuant);
			stmt.setInt(1, quantidade);
			stmt.execute();
			stmt.close();
		
			resultSet = stmt.getResultSet();
			
			while(resultSet.next()){
				trabAtual = new Trabalho();
				trabAtual.setIdTrabalho(resultSet.getInt("id_tra"));
				trabAtual.setTitulo(resultSet.getString("titulo_tra"));
				trabAtual.setResumo(resultSet.getString("resumo_tra"));
				trabAtual.setStatus(StatusTrabalho.getStatusByNome(resultSet.getString("status_tra")));
				trabAtual.setCurtidas(resultSet.getInt("numero_curtidas_tra"));
				trabs_encontrados.add(trabAtual);
			}

			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trabs_encontrados;
	}
}
