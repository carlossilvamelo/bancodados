package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bancodados.dominio.Discente;

public class UsuarioDao {

	
	public String verificarTipoUsuarioPorCpf(String cpf){
		String tipo = null;
	
		String sql = "select * from view_discente where cpf_usu = ?";
		

		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setString(1, cpf);

			// executa
			stmt.execute();
			
			ResultSet resultSet =  stmt.getResultSet();
			while(resultSet.next()){
				tipo = resultSet.getString("tipo_usu");
				
			}
			

			stmt.close();
			ConnectionManager.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tipo;
	}
	
}
