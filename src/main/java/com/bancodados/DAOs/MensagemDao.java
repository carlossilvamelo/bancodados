package com.bancodados.DAOs;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Mensagem;
import com.bancodados.dominio.Usuario;

public class MensagemDao {

	public void enviarMensagem(Usuario remetente, Usuario destinatario, String mensagem) {

		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		// operação 1
		String inserirUsuario = "insert into mensagem (id_remetente_men,id_destinatario_men, conteudo_men, hora_data_men) "
				+ "values(?,?,?,?);";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(inserirUsuario);

			stmt.setInt(1, remetente.getId());
			stmt.setInt(2, destinatario.getId());
			stmt.setString(3, mensagem);
			stmt.setDate(4, new Date(1));
			stmt.execute();
			stmt.close();



			System.out.println("mensagem enviada: de:"+remetente.getNome()+" Para:"+destinatario.getNome());
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Mensagem> buscarMensagens(Usuario remetente, Usuario destinatario) {

		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
		// operação 1
		String inserirUsuario = "select cpf_usu,id_usu, nome_inf, id_remetente_men, id_destinatario_men, "
				+ "hora_data_men, conteudo_men from usuario "
				+ "inner join info_usuario on id_usu = id_inf "
				+ "inner join mensagem on id_remetente_men=id_usu where "
				+ "(id_remetente_men= ? and id_destinatario_men= ?) "
				+ "or (id_remetente_men= ? and id_destinatario_men= ?) order by id_men asc;";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(inserirUsuario);
					
			stmt.setInt(1, remetente.getId());
			stmt.setInt(2, destinatario.getId());
			stmt.setInt(3, destinatario.getId());
			stmt.setInt(4, remetente.getId());
			stmt.execute();
			resultSet = stmt.getResultSet();
			Mensagem mensagem =  null;
			while(resultSet.next()){
				mensagem = new Mensagem();
				mensagem.setIdRemetente(resultSet.getInt("id_remetente_men"));
				mensagem.setIdDestinatario(resultSet.getInt("id_destinatario_men"));
				mensagem.setConteudo(resultSet.getString("conteudo_men"));
				mensagem.setDataHora(resultSet.getDate("hora_data_men"));
				mensagens.add(mensagem);
			}

			stmt.close();
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mensagens;
	}





}
