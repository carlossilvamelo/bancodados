package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;


public class DiscenteDao {
	
	
	public void inserirDiscente(Discente discente) throws SQLException{
		 // conectando
       //Connection con = ConnectionManager.getConnection();

       // cria um preparedStatement
       String sql =  "insert into usuario (id_usu, login_usu, senha_usu, nome_usu, cpf_usu"
       		+ ", email_usu, data_nascimento_usu, curriculo_usu, rua_usu, numero_usu, cep_usu"
       		+ ", estado_usu) "
       		+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
       
       PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(sql);

       // preenche os valores
       stmt.setInt(1, discente.getId());
       stmt.setString(2, discente.getLogin());
       stmt.setString(3, discente.getSenha());
       stmt.setString(4,  discente.getNome());
       stmt.setString(5, discente.getCpf());
       stmt.setString(6, discente.getEmail());
       stmt.setDate(7, discente.getDataNascimento());
       stmt.setString(8,discente.getCurriculo());
       stmt.setString(9, discente.getEndereco().getRua());
       stmt.setInt(10, discente.getEndereco().getNumero());
       stmt.setString(11, discente.getEndereco().getCep());
       stmt.setString(12, "Caelum");

       // executa
       stmt.execute();
       stmt.close();

       System.out.println("Docente inserido!");
       ConnectionManager.closeConnection();
       
	}
	
	public Discente buscarDocentePorCpf(){
		Discente discente = null;
		
		return discente;
	}
	
	public Discente buscarDocentePorEmailSenha(String email, String senha){
		Discente discente = null;
		String sql = "select * from usuario"
				+ "join endereco_usuario on id_usu = id_usu_end"
				+ "join identificacao on login_usu = login_ide"
				+ "join endereco_complemento on cep_usu = cep_com"
				+ "join info_usuario on cpf_usu = cpf_inf;";
		

		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			
			stmt.setString(1, email);

			// executa
			stmt.execute();
			
			ResultSet resultSet =  stmt.getResultSet();
			while(resultSet.next()){
				discente = new Discente();
				
				discente.setCpf(resultSet.getString("cpf_usu"));
				discente.setLogin(resultSet.getString("login_usu"));
				discente.setEmail(resultSet.getString("email_usu"));
				discente.getEndereco().setCep(resultSet.getString("cep_usu"));
				discente.setTipo(resultSet.getString("tipo_uso"));
				discente.setSenha(resultSet.getString("senha_ide"));
			}
			

			stmt.close();
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return discente;
	}
}
