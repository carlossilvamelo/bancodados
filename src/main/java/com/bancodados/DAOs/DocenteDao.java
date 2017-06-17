package com.bancodados.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.bancodados.dominio.Docente;



public class DocenteDao {

	
	
	
	public void inserirDocente(Docente docente) throws SQLException{
		 // conectando
       // Connection con = ConnectionManager.getConnection();

        // cria um preparedStatement
        String sql =  "insert into usuario (id_usu, login_usu, senha_usu, nome_usu, cpf_usu"
        		+ ", email_usu, data_nascimento_usu, curriculo_usu, rua_usu, numero_usu, cep_usu"
        		+ ", estado_usu) "
        		+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(sql);

        // preenche os valores
        stmt.setInt(1, docente.getId());
        stmt.setString(2, docente.getLogin());
        stmt.setString(3, docente.getSenha());
        stmt.setString(4,  docente.getNome());
        stmt.setString(5, docente.getCpf());
        stmt.setString(6, docente.getEmail());
        stmt.setDate(7, docente.getDataNascimento());
        stmt.setString(8,docente.getCurriculo());
        stmt.setString(9, docente.getEndereco().getRua());
        stmt.setInt(10, docente.getEndereco().getNumero());
        stmt.setString(11, docente.getEndereco().getCep());
        stmt.setString(12, "Caelum");

        // executa
        stmt.execute();
        stmt.close();

        System.out.println("Docente inserido!");
        ConnectionManager.closeConnection();
        
	}
	
	public Docente buscarDocentePorCpf(){
		Docente docente = null;
		
		return docente;
	}
	
	
	
}
