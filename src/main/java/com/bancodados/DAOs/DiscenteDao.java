package com.bancodados.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;


public class DiscenteDao {
	
	
	public void inserirDiscente(Discente discente) throws SQLException{
		
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		// operação 1
		String inserirUsuario = "insert into usuario (login_usu, cpf_usu, email_usu, cep_usu, tipo_usu)"
				+ "values(?,?,?,?,?) ";
		 stmt = ConnectionManager.getConnection().prepareStatement(inserirUsuario);
		 stmt.setString(1, discente.getLogin());
		 stmt.setString(2, discente.getCpf());
		 stmt.setString(3, discente.getEmail());
		 stmt.setString(4, discente.getEndereco().getCep());
		 stmt.setString(5, discente.getTipo());
		 stmt.execute();
	     stmt.close();
		
		
		
		// operação 2
       String id_usuario =  "select id_usu from usuario where cpf_usu = ?";
       stmt = ConnectionManager.getConnection().prepareStatement(id_usuario);
       stmt.setString(1, discente.getCpf());
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
       stmt.setString(2, discente.getEmail());
       stmt.setString(3, discente.getSenha());
       stmt.execute();
       stmt.close();
       
       
    // operação 4
       String inserirEnderecoUsuario = "insert into endereco_usuario (id_usu_end, rua_end, cep_end, numero_end)"
       		+ "values(?, ?, ?, ?)";
       stmt = ConnectionManager.getConnection().prepareStatement(inserirEnderecoUsuario);
       stmt.setInt(1, idUsuario);
       stmt.setString(2, discente.getEndereco().getRua());
       stmt.setString(3, discente.getEndereco().getCep());
       stmt.setInt(4, discente.getEndereco().getNumero());
       stmt.execute();
       stmt.close();
       
    // operação 5
       String inserirInfoUsuario = "insert into info_usuario(id_inf, curriculo_inf, data_nascimento_inf, nome_inf)"
       		+ "values(?, ?, ?, ?)";
       stmt = ConnectionManager.getConnection().prepareStatement(inserirInfoUsuario);
       stmt.setInt(1, idUsuario);
       stmt.setString(2, discente.getCurriculo());
       stmt.setDate(3, discente.getDataNascimento());
       stmt.setString(4, discente.getNome());
       stmt.execute();
       stmt.close();
       
       
    // operação 6
       String inserirEnderecoComplemento = "insert into endereco_complemento (id_end_com, estado_com, rua_com)"
       		+ "values(?, ?, ?)";
       stmt = ConnectionManager.getConnection().prepareStatement(inserirEnderecoComplemento);
       stmt.setInt(1, idUsuario);
       stmt.setString(2, discente.getEndereco().getEstado());
       stmt.setString(3, discente.getEndereco().getRua());
       stmt.execute();
       stmt.close();
       
    // operação 7
       String inserirDiscente = "insert into discente (id_usuario_dis, matricula_dis, reputacao_dis)"
       		+ "values(?, ?, ?)";
       stmt = ConnectionManager.getConnection().prepareStatement(inserirDiscente);
       stmt.setInt(1, idUsuario);
       stmt.setString(2, discente.getMatricula());
       stmt.setString(3, discente.getReputacao());
       stmt.execute();
       stmt.close();
       
       

       System.out.println("Docente inserido!");
       ConnectionManager.closeConnection();
       
	}
	
	
	
	
	
	public Discente buscarDiscentePorCpf(String cpf){
		Discente discente = null;
	
		String sql = "select * from view_discente where cpf_usu = ?";
		

		PreparedStatement stmt;
		try {
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setString(1, cpf);

			// executa
			stmt.execute();
			
			ResultSet resultSet =  stmt.getResultSet();
			while(resultSet.next()){
				discente = new Discente();
				discente.setId(resultSet.getInt("id_usu"));
				discente.setLogin(resultSet.getString("login_usu"));
				discente.setCpf(resultSet.getString("cpf_usu"));
				discente.setEmail(resultSet.getString("email_usu"));
				discente.getEndereco().setCep(resultSet.getString("cep_usu"));
				discente.setTipo(resultSet.getString("tipo_usu"));
				discente.getEndereco().setRua(resultSet.getString("rua_end"));
				discente.getEndereco().setNumero(resultSet.getInt("numero_end"));
				discente.setSenha(resultSet.getString("senha_ide"));
				discente.getEndereco().setEstado(resultSet.getString("estado_com"));
				discente.setCurriculo(resultSet.getString("curriculo_inf"));
				discente.setDataNascimento(resultSet.getDate("data_nascimento_inf"));
				discente.setNome(resultSet.getString("nome_inf"));
				discente.setMatricula(resultSet.getString("matricula_dis"));
				discente.setReputacao(resultSet.getString("reputacao_dis"));
				
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
