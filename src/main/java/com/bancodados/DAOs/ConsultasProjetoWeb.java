package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;

public class ConsultasProjetoWeb {


	public void inserirDiscente(){}

	public void inserirDocente(){}

	public String verificarTipoPorEmail(String email){
		String tipo = null;

		String sql =  "select tipo from usuario where email = ?";

		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);

			stmt.setString(1, email);

			// executa
			stmt.execute();

			ResultSet resultSet =  stmt.getResultSet();
			ArrayList<String> listaUsuarios = new ArrayList<String>();
			while(resultSet.next()){
				listaUsuarios.add(resultSet.getString("tipo"));
			}
			if(listaUsuarios.size() != 0){
				tipo = listaUsuarios.get(0);
			}

			stmt.close();
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return tipo;
	}



	public void inserirDiscente(Discente discente) {
		// conectando
		//Connection con = ConnectionManager.getConnection();

		// cria um preparedStatement
		String sql =  "insert into usuario (cpf, login, senha, email, nome, sobre_nome, matricula,"
				+ "data_nascimento, curriculo, cep, rua, numero, estado, tipo) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, discente.getCpf());
			stmt.setString(2, discente.getLogin());
			stmt.setString(3, discente.getSenha());
			stmt.setString(4, discente.getEmail());
			stmt.setString(5, discente.getNome());
			stmt.setString(6, discente.getSobreNome());
			stmt.setString(7, discente.getMatricula());
			stmt.setDate(8, discente.getDataNascimento());
			stmt.setString(9,discente.getCurriculo());
			stmt.setString(10, discente.getEndereco().getCep());
			stmt.setString(11, discente.getEndereco().getRua());
			stmt.setInt(12, discente.getEndereco().getNumero());
			stmt.setString(13, discente.getEndereco().getEstado());
			stmt.setString(14, discente.getTipo());



			// executa
			stmt.execute();
			stmt.close();

			System.out.println("Docente inserido!");
			ConnectionManager.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void atualizarDiscente(Discente discente){
		String sql = "UPDATE usuario SET  cpf = ?, login = ?, senha = ?, email = ?, nome = ?,"
				+ " sobre_nome = ?, matricula = ?,"
				+ "data_nascimento = ?, curriculo = ?, cep = ?, rua = ?, numero = ?, estado = ?, tipo = ? "
				+ "WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setString(1, discente.getCpf());
			stmt.setString(2, discente.getLogin());
			stmt.setString(3, discente.getSenha());
			stmt.setString(4, discente.getEmail());
			stmt.setString(5, discente.getNome());
			stmt.setString(6, discente.getSobreNome());
			stmt.setString(7, discente.getMatricula());
			stmt.setDate(8, discente.getDataNascimento());
			stmt.setString(9,discente.getCurriculo());
			stmt.setString(10, discente.getEndereco().getCep());
			stmt.setString(11, discente.getEndereco().getRua());
			stmt.setInt(12, discente.getEndereco().getNumero());
			stmt.setString(13, discente.getEndereco().getEstado());
			stmt.setString(14, discente.getTipo());
			stmt.setInt(15, discente.getId());
			
			// execute insert SQL stetement
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void atualizarDocente(Docente docente){
		String sql = "UPDATE usuario SET  cpf = ?, login = ?, senha = ?, email = ?, nome = ?,"
				+ " sobre_nome = ?, data_nascimento = ?, curriculo = ?, cep = ?, rua = ?,"
				+ " numero = ?, estado = ?, tipo = ? WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setString(1, docente.getCpf());
			stmt.setString(2, docente.getLogin());
			stmt.setString(3, docente.getSenha());
			stmt.setString(4, docente.getEmail());
			stmt.setString(5, docente.getNome());
			stmt.setString(6, docente.getSobreNome());
			stmt.setDate(7, docente.getDataNascimento());
			stmt.setString(8,docente.getCurriculo());
			stmt.setString(9, docente.getEndereco().getCep());
			stmt.setString(10, docente.getEndereco().getRua());
			stmt.setInt(11, docente.getEndereco().getNumero());
			stmt.setString(12, docente.getEndereco().getEstado());
			stmt.setString(13, docente.getTipo());
			stmt.setInt(14, docente.getId());
			
			// execute insert SQL stetement
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inserirDocente(Docente docente) {
		// conectando
		//Connection con = ConnectionManager.getConnection();

		// cria um preparedStatement
		String sql =  "insert into usuario (cpf, login, senha, email, nome, sobre_nome,"
				+ "data_nascimento, curriculo, cep, rua, numero, estado, tipo) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, docente.getCpf());
			stmt.setString(2, docente.getLogin());
			stmt.setString(3, docente.getSenha());
			stmt.setString(4, docente.getEmail());
			stmt.setString(5, docente.getNome());
			stmt.setString(6, docente.getSobreNome());
			stmt.setDate(7, docente.getDataNascimento());
			stmt.setString(8,docente.getCurriculo());
			stmt.setString(9, docente.getEndereco().getCep());
			stmt.setString(10, docente.getEndereco().getRua());
			stmt.setInt(11, docente.getEndereco().getNumero());
			stmt.setString(12, docente.getEndereco().getEstado());
			stmt.setString(13, docente.getTipo());



			// executa
			stmt.execute();
			stmt.close();

			System.out.println("Docente inserido!");
			ConnectionManager.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public Discente buscarDiscentePorEmailSenha(String email, String senha){
		Discente discente = null;
		String sql = "select * from usuario where email = ? and senha = ?;";


		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);

			stmt.setString(1, email);
			stmt.setString(2, senha);

			// executa
			stmt.execute();

			ResultSet resultSet =  stmt.getResultSet();
			while(resultSet.next()){
				discente = new Discente();
				discente.setId(resultSet.getInt("id"));
				discente.setCpf(resultSet.getString("cpf"));
				discente.setLogin(resultSet.getString("login"));
				discente.setSenha(resultSet.getString("senha"));
				discente.setEmail(resultSet.getString("email"));
				discente.setNome(resultSet.getString("nome"));
				discente.setSobreNome(resultSet.getString("sobre_nome"));
				discente.setMatricula(resultSet.getString("matricula"));
				discente.setDataNascimento(resultSet.getDate("data_nascimento"));
				discente.setCurriculo(resultSet.getString("curriculo"));
				discente.getEndereco().setCep(resultSet.getString("cep"));
				discente.getEndereco().setRua(resultSet.getString("rua"));
				discente.getEndereco().setNumero(resultSet.getInt("numero"));
				discente.getEndereco().setEstado(resultSet.getString("estado"));
				discente.setTipo(resultSet.getString("tipo"));
				
			}


			stmt.close();
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return discente;
	}

	public Docente buscarDocentePorEmailSenha(String email, String senha){
		Docente docente = null;
		String sql = "select * from usuario where email = ? and senha = ?;";


		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);

			stmt.setString(1, email);
			stmt.setString(2, senha);

			// executa
			stmt.execute();

			ResultSet resultSet =  stmt.getResultSet();
			while(resultSet.next()){
				docente = new Docente();
				docente.setId(resultSet.getInt("id"));
				docente.setCpf(resultSet.getString("cpf"));
				docente.setLogin(resultSet.getString("login"));
				docente.setSenha(resultSet.getString("senha"));
				docente.setEmail(resultSet.getString("email"));
				docente.setNome(resultSet.getString("nome"));
				docente.setSobreNome(resultSet.getString("sobre_nome"));
				docente.setDataNascimento(resultSet.getDate("data_nascimento"));
				docente.setCurriculo(resultSet.getString("curriculo"));
				docente.getEndereco().setCep(resultSet.getString("cep"));
				docente.getEndereco().setRua(resultSet.getString("rua"));
				docente.getEndereco().setNumero(resultSet.getInt("numero"));
				docente.getEndereco().setEstado(resultSet.getString("estado"));
				docente.setTipo(resultSet.getString("tipo"));
				
			}


			stmt.close();
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return docente;
	}
	
	
}
