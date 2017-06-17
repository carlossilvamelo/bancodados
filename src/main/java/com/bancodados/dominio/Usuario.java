package com.bancodados.dominio;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class Usuario {
	
	
	private Integer usuarioId;
	private String nome;
	private String sobreNome;
	private String login;
	private String senha;
	private String tipo;
	private String cpf;
	private Endereco endereco;
	private String email;
	private String curriculo;
	private Date dataNascimento;
	private Identificacao identidicacao;
	private List<String> areasConhecimentos;
	private List<Mensagem> mensagens;
	
	
	
	
	//contrutores
	

	public Usuario() {
		// TODO Auto-generated constructor stub
	}



	//esse metodo vai para o clienteService
	public Integer calcularIdadePorDataNascimento(Calendar dataNascimento){
		return null;
	}

	public Integer getId() {
		return usuarioId;
	}

	public void setId(Integer id) {
		this.usuarioId = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	

	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}



	public Identificacao getIdentidicacao() {
		return identidicacao;
	}

	public void setIdentidicacao(Identificacao identidicacao) {
		this.identidicacao = identidicacao;
	}

	public List<String> getAreasConhecimentos() {
		return areasConhecimentos;
	}

	public void setAreasConhecimentos(List<String> areasConhecimentos) {
		this.areasConhecimentos = areasConhecimentos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getSobreNome() {
		return sobreNome;
	}



	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	
	//getters and setters
	
	
	
}
