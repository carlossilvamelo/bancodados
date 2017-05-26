package com.bancodados.dominio;


public class Endereco {
	
	private Integer enderecoId;
	private String rua;
	private Integer numero;
	private Integer cep;
	private String estado;
	

	//Construtores
	public Endereco(String rua, Integer numero, Integer cep, String estado) {
		
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.estado = estado;
	}
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getters and setters
	public Integer getId() {
		return enderecoId;
	}
	public void setId(Integer id) {
		this.enderecoId = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
