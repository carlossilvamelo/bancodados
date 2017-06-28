package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.servlet.ResourceServlet;

import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Usuario;

public class ContatosDiscenteDao {


	public void inserirContato(Discente discenteA, Discente discenteB){

		PreparedStatement stmt = null;
		// operação 1


		try {
			String inserirContato = "insert into contato (id_usu_a, id_usu_b) values(?,?);";

			stmt = ConnectionManager.getConnection().prepareStatement(inserirContato);

			stmt.setString(1, discenteA.getCpf());
			stmt.setString(2, discenteB.getCpf());
			stmt.execute();
			stmt.close();


			//operacao 2

			stmt = ConnectionManager.getConnection().prepareStatement(inserirContato);
			stmt.setString(1, discenteB.getCpf());
			stmt.setString(2, discenteA.getCpf());

			stmt.execute();
			stmt.close();





			System.out.println("contato inserido!");
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	
	
	public void excluirContato(Discente discenteA, Discente discenteB){

		PreparedStatement stmt = null;
		// operação 1


		try {
			String inserirContato = "delete from contato where id_usu_a = ? "
					+ "and id_usu_b = ?;";

			stmt = ConnectionManager.getConnection().prepareStatement(inserirContato);

			stmt.setString(1, discenteA.getCpf());
			stmt.setString(2, discenteB.getCpf());
			stmt.execute();
			stmt.close();
			
			
			stmt = ConnectionManager.getConnection().prepareStatement(inserirContato);
			stmt.setString(1, discenteB.getCpf());
			stmt.setString(2, discenteA.getCpf());
			stmt.execute();
			stmt.close();


	
			System.out.println("contato excluido!");
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Usuario> buscarContatos(Discente discente){
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		Usuario usuario = null;
		ArrayList<Usuario> contatos = new ArrayList<Usuario>();

		// operação 1



		try {
			String buscarContato = "select nome_inf, cpf_usu, id_usu from info_usuario "
					+ "inner join (select id_usu, cpf_usu from usuario "
					+ "inner join(select id_usu_b from contato where id_usu_a = ?) as cont "
					+ "on cont.id_usu_b = cpf_usu) as id_cont "
					+ "on id_inf = id_cont.id_usu;";

			stmt = ConnectionManager.getConnection().prepareStatement(buscarContato);
			stmt.setString(1, discente.getCpf());
			stmt.execute();

			resultSet = stmt.getResultSet();


			while(resultSet.next()){

				usuario = new Usuario();
				usuario.setNome(resultSet.getString("nome_inf"));
				usuario.setCpf(resultSet.getString("cpf_usu"));
				usuario.setId(resultSet.getInt("id_usu"));
				contatos.add(usuario);
			}

			stmt.close();

			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contatos;

	}


	public ArrayList<Usuario> buscarTodosUsuarios(){
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		Usuario usuario = null;
		ArrayList<Usuario> contatos = new ArrayList<Usuario>();

		// operação 1



		try {
			String buscarContato = "SELECT * FROM usuario join info_usuario on id_usu = id_inf;";

			stmt = ConnectionManager.getConnection().prepareStatement(buscarContato);
			stmt.execute();

			resultSet = stmt.getResultSet();


			while(resultSet.next()){

				usuario = new Usuario();
				usuario.setNome(resultSet.getString("nome_inf"));
				usuario.setCpf(resultSet.getString("cpf_usu"));
				usuario.setId(resultSet.getInt("id_usu"));
				usuario.setLogin(resultSet.getString("login_usu"));
				usuario.setEmail(resultSet.getString("email_usu"));
				contatos.add(usuario);
			}

			stmt.close();

			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contatos;

	}




}
