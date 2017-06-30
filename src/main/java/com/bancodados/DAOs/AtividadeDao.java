package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bancodados.dominio.Atividade;
import com.bancodados.dominio.Discente;

public class AtividadeDao {

	public void inserirAtividade(Atividade ativ) {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		// operação 1
		String inserirAtividade = "INSERT INTO atividade (id_tra_ati, prazo_ati, descricao_ati, observacao_ati, status_ati) "
				+ "VALUES (?, ?, ?, ?, ?);";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(inserirAtividade);

			stmt.setInt(1, ativ.getIdTrabalho());
			stmt.setDate(2, ativ.getPrazo());
			stmt.setString(3, ativ.getDescricao());
			stmt.setString(4, ativ.getObservacao());
			stmt.setInt(5, ativ.getStatus().getValor());
			stmt.execute();
			stmt.close();

			// operação 2
			String procurarAtividadeID = "SELECT id_ati FROM atividade "
					+ "WHERE id_tra_ati = ?, prazo_ati = ?, descricao_ati = ?, observacao_ati = ?, status_ati = ?;";
			stmt = ConnectionManager.getConnection().prepareStatement(procurarAtividadeID);
			stmt.setInt(1, ativ.getIdTrabalho());
			stmt.setDate(2, ativ.getPrazo());
			stmt.setString(3, ativ.getDescricao());
			stmt.setString(4, ativ.getObservacao());
			stmt.setInt(5, ativ.getStatus().getValor());
			stmt.execute();

			resultSet = stmt.getResultSet();
			while (resultSet.next()) {
				ativ.setIdAtividade(resultSet.getInt("id_ati"));
				break;
			}

			stmt.close();

			// operação 3
			String inserirParticipantes = "INSERT INTO participante_atividade (id_discente_par, id_atividade_par) "
					+ "VALUES (?, ?);";
			for (Discente part : ativ.getParticipantes()) {
				stmt = ConnectionManager.getConnection().prepareStatement(inserirParticipantes);
				stmt.setInt(1, part.getId());
				stmt.setInt(2, ativ.getIdAtividade());
				stmt.execute();
				stmt.close();
			}
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Atividade buscarAtividadePorID(int id_ativ){
		Atividade ativ = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		//operação 1
		String buscarAtivPorId = "SELECT * FROM atividade WHERE id_ati = ?";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(buscarAtivPorId);
			stmt.setInt(1, id_ativ);
			stmt.execute();
			
			resultSet = stmt.getResultSet();
			while(resultSet.next()){
				ativ = new Atividade();
				
				ativ.setIdAtividade(id_ativ);
				ativ.setDescricao(resultSet.getString("descricao_ati"));
				ativ.setIdTrabalho(resultSet.getInt("id_tra_ati"));
				ativ.setObservacao(resultSet.getString("observacao_ati"));
				ativ.setPrazo(resultSet.getDate("prazo_ati"));
				ativ.setStatus(resultSet.getInt("status_ati"));
			}
			stmt.close();
			
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ativ.setParticipantes(this.buscarDiscentesPorAtividade(id_ativ));
		
		return ativ;
	}
	
	public ArrayList<Atividade> buscarAtividadesPorTrabalho(int id_trab){
		ArrayList<Atividade> atividadesTrab = new ArrayList<Atividade>();
		Atividade ativ = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		//operação 1
		String buscarAtivPorId = "SELECT * FROM atividade WHERE id_tra_ati = ?";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(buscarAtivPorId);
			stmt.setInt(1, id_trab);
			stmt.execute();
			
			resultSet = stmt.getResultSet();
			while(resultSet.next()){
				ativ = new Atividade();
				
				ativ.setIdAtividade(resultSet.getInt("id_ati"));
				ativ.setDescricao(resultSet.getString("descricao_ati"));
				ativ.setIdTrabalho(resultSet.getInt("id_tra_ati"));
				ativ.setObservacao(resultSet.getString("observacao_ati"));
				ativ.setPrazo(resultSet.getDate("prazo_ati"));
				ativ.setStatus(resultSet.getInt("status_ati"));
				atividadesTrab.add(ativ);
			}
			stmt.close();
			
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Atividade ativTrab : atividadesTrab){
			ativTrab = this.buscarAtividadePorID(ativTrab.getIdAtividade());
		}
		
		return atividadesTrab;
	}

	public ArrayList<Discente> buscarDiscentesPorAtividade(int idAtiv){
		ArrayList<Discente> participantes = new ArrayList<Discente>();
		Discente participante = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		DiscenteDao discenteDao = new DiscenteDao();
		
		String buscarIDDiscentes = "SELECT id_discente_par FROM participante_atividade WHERE id_atividade_par = ?";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(buscarIDDiscentes);
			stmt.setInt(1, idAtiv);
			stmt.execute();
			
			resultSet = stmt.getResultSet();
			while(resultSet.next()){
				participante = new Discente();
				participante.setId(resultSet.getInt("id_discente_par"));
				participantes.add(participante);
			}
			stmt.close();
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Discente part : participantes){
			part = discenteDao.buscarDiscentePorId(part.getId());
		}
		
		return participantes;
	}
	
}
