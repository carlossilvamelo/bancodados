package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;


public class DiscenteDao {
	
	
	public void inserirDiscente(Docente discente) throws SQLException{
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
	
}
