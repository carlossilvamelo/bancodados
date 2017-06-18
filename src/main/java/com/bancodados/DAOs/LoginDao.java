package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bancodados.dominio.Usuario;

public class LoginDao {



	public String verificarTipoPorEmail(String email){
		String tipo = null;

		String sql =  "select tipo_uso from usuario where email_usu = ?";

		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			
			stmt.setString(1, email);

			// executa
			stmt.execute();
			
			ResultSet resultSet =  stmt.getResultSet();
			ArrayList<String> listaUsuarios = new ArrayList<String>();
			while(resultSet.next()){
				listaUsuarios.add(resultSet.getString("tipo_uso"));
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

	

}
