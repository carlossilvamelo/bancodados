package com.bancodados.dominio;

import java.util.Calendar;
import java.util.List;

public class Usuario {
	
	
	private Integer usuarioId;
	private String nome;
	private Integer idade;
	private String tipo;
	private Integer cpf;
	private Endereco endereco;
	private String email;
	private String curriculo;
	private Calendar dataNascimento;
	private Identificacao identidicacao;
	private List<String> areasConhecimentos;
	private List<Mensagem> mensagens;
	
	
	
	
	//contrutores
	public Usuario(String nome, Integer idade, Integer cpf, Endereco endereco, String email,
			String curriculo, Calendar dataNascimento, Identificacao identidicacao) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.curriculo = curriculo;
		this.dataNascimento = dataNascimento;
		this.identidicacao = identidicacao;
	}

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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	
	
	//getters and setters
	
	
	
}
