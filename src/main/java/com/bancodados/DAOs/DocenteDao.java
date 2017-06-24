package com.bancodados.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;



public class DocenteDao {




	public void inserirDocente(Docente docente) {

		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		// operação 1
		String inserirUsuario = "insert into usuario (login_usu, cpf_usu, email_usu, cep_usu, tipo_usu)"
				+ "values(?,?,?,?,?) ";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(inserirUsuario);

			stmt.setString(1, docente.getLogin());
			stmt.setString(2, docente.getCpf());
			stmt.setString(3, docente.getEmail());
			stmt.setString(4, docente.getEndereco().getCep());
			stmt.setString(5, docente.getTipo());
			stmt.execute();
			stmt.close();



			// operação 2
			String id_usuario =  "select id_usu from usuario where cpf_usu = ?";
			stmt = ConnectionManager.getConnection().prepareStatement(id_usuario);
			stmt.setString(1, docente.getCpf());
			stmt.execute();
			resultSet =  stmt.getResultSet();
			Integer idUsuario = null;
			while(resultSet.next()){
				idUsuario = resultSet.getInt("id_usu");
			}
			stmt.close();

			// operação 3
			String inserirIdentificacao =  "insert into identificacao (id_ide, email_ide, senha_ide)"
					+ "values(?, ?, ?)";
			stmt = ConnectionManager.getConnection().prepareStatement(inserirIdentificacao);
			stmt.setInt(1, idUsuario);
			stmt.setString(2, docente.getEmail());
			stmt.setString(3, docente.getSenha());
			stmt.execute();
			stmt.close();


			// operação 4
			String inserirEnderecoUsuario = "insert into endereco_usuario (id_usu_end, rua_end, cep_end, numero_end)"
					+ "values(?, ?, ?, ?)";
			stmt = ConnectionManager.getConnection().prepareStatement(inserirEnderecoUsuario);
			stmt.setInt(1, idUsuario);
			stmt.setString(2, docente.getEndereco().getRua());
			stmt.setString(3, docente.getEndereco().getCep());
			stmt.setInt(4, docente.getEndereco().getNumero());
			stmt.execute();
			stmt.close();

			// operação 5
			String inserirInfoUsuario = "insert into info_usuario(id_inf, curriculo_inf, data_nascimento_inf, nome_inf)"
					+ "values(?, ?, ?, ?)";
			stmt = ConnectionManager.getConnection().prepareStatement(inserirInfoUsuario);
			stmt.setInt(1, idUsuario);
			stmt.setString(2, docente.getCurriculo());
			stmt.setDate(3, docente.getDataNascimento());
			stmt.setString(4, docente.getNome());
			stmt.execute();
			stmt.close();


			// operação 6
			String inserirEnderecoComplemento = "insert into endereco_complemento (id_end_com, estado_com, rua_com)"
					+ "values(?, ?, ?)";
			stmt = ConnectionManager.getConnection().prepareStatement(inserirEnderecoComplemento);
			stmt.setInt(1, idUsuario);
			stmt.setString(2, docente.getEndereco().getEstado());
			stmt.setString(3, docente.getEndereco().getRua());
			stmt.execute();
			stmt.close();

			// operação 7
			String inserirDiscente = "insert into docente (id_usuario_doc)"
					+ "values(?)";
			stmt = ConnectionManager.getConnection().prepareStatement(inserirDiscente);
			stmt.setInt(1, idUsuario);
			stmt.execute();
			stmt.close();

			System.out.println("Docente inserido!");
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}





	public Docente buscarDocentePorCpf(String cpf){
		Docente docente = null;

		String sql = "select * from view_docente where cpf_usu = ?";


		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setString(1, cpf);

			// executa
			stmt.execute();

			ResultSet resultSet =  stmt.getResultSet();
			while(resultSet.next()){
				docente = new Docente();
				docente.setId(resultSet.getInt("id_usu"));
				docente.setLogin(resultSet.getString("login_usu"));
				docente.setCpf(resultSet.getString("cpf_usu"));
				docente.setEmail(resultSet.getString("email_usu"));
				docente.getEndereco().setCep(resultSet.getString("cep_usu"));
				docente.setTipo(resultSet.getString("tipo_usu"));
				docente.getEndereco().setRua(resultSet.getString("rua_end"));
				docente.getEndereco().setNumero(resultSet.getInt("numero_end"));
				docente.setSenha(resultSet.getString("senha_ide"));
				docente.getEndereco().setEstado(resultSet.getString("estado_com"));
				docente.setCurriculo(resultSet.getString("curriculo_inf"));
				docente.setDataNascimento(resultSet.getDate("data_nascimento_inf"));
				docente.setNome(resultSet.getString("nome_inf"));


			}


			stmt.close();
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return docente;
	}



	public void atualizarDocente(Docente docente){


		//operação 0


		PreparedStatement stmt = null;
		// operação 1
		String inserirUsuario = "UPDATE usuario SET login_usu = ?, cpf_usu = ?,"
				+ " email_usu = ?, cep_usu = ?, tipo_usu = ?"
				+ "WHERE id_usu = ?;";
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(inserirUsuario);

			stmt.setString(1, docente.getLogin());
			stmt.setString(2, docente.getCpf());
			stmt.setString(3, docente.getEmail());
			stmt.setString(4, docente.getEndereco().getCep());
			stmt.setString(5, docente.getTipo());
			stmt.setInt(6, docente.getId());

			stmt.execute();
			stmt.close();





			// operação 3
			String atualizarIdentificacao =  "UPDATE identificacao SET email_ide = ?,"
					+ " senha_ide = ? WHERE id_ide = ?;";
			stmt = ConnectionManager.getConnection().prepareStatement(atualizarIdentificacao);
			stmt.setString(1, docente.getEmail());
			stmt.setString(2, docente.getSenha());
			stmt.setInt(3, docente.getId());
			stmt.execute();
			stmt.close();


			// operação 4
			String atualizarEnderecoUsuario = "UPDATE endereco_usuario SET id_usu_end = ?,"
					+ " rua_end = ?, cep_end = ?, numero_end = ? "
					+ "WHERE id_usu_end = ?;";
			stmt = ConnectionManager.getConnection().prepareStatement(atualizarEnderecoUsuario);
			stmt.setInt(1, docente.getId());
			stmt.setString(2, docente.getEndereco().getRua());
			stmt.setString(3, docente.getEndereco().getCep());
			stmt.setInt(4, docente.getEndereco().getNumero());
			stmt.setInt(5, docente.getId());
			stmt.execute();
			stmt.close();

			// operação 5
			String inserirInfoUsuario = "UPDATE info_usuario SET curriculo_inf = ?,"
					+ " data_nascimento_inf = ?, nome_inf = ? "
					+ "WHERE id_inf = ?;";
			stmt = ConnectionManager.getConnection().prepareStatement(inserirInfoUsuario);
			stmt.setString(1, docente.getCurriculo());
			stmt.setDate(2, docente.getDataNascimento());
			stmt.setString(3, docente.getNome());
			stmt.setInt(4, docente.getId());
			stmt.execute();
			stmt.close();


			// operação 6
			String atualizarEnderecoComplemento = "UPDATE endereco_complemento SET"
					+ "  id_end_com = ?, estado_com =?, rua_com = ? "
					+ "WHERE id_end_com = ?;";
			stmt = ConnectionManager.getConnection().prepareStatement(atualizarEnderecoComplemento);
			stmt.setInt(1, docente.getId());
			stmt.setString(2, docente.getEndereco().getEstado());
			stmt.setString(3, docente.getEndereco().getRua());
			stmt.setInt(4, docente.getId());
			stmt.execute();
			stmt.close();

			// operação 7
			String atualizarDocente = "UPDATE docente SET id_usuario_doc = ?"
					+ " WHERE id_doc = ?;";
			stmt = ConnectionManager.getConnection().prepareStatement(atualizarDocente);
			stmt.setInt(1, docente.getId());
			stmt.setInt(2, docente.getId());
			stmt.execute();
			stmt.close();

			System.out.println("Docente inserido!");
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}
