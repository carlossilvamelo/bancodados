package com.bancodados.dominio;



public class Identificacao {
	
	private Integer identificacaoUsuarioid;
	private String login;
	private String senha;
	
	public Identificacao(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Identificacao() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getters and setters
	public Integer getId() {
		return identificacaoUsuarioid;
	}
	
	public void setId(Integer id) {
		this.identificacaoUsuarioid = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
