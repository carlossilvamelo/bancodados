package com.bancodados.dominio;


public class Endereco {
	
	private Integer idEndereco;
	private String rua;
	private Integer numero;
	private String cep;
	private String estado;
	

	
	
	public Endereco() {
		
		
		this.rua = "";
		this.numero = 0;
		this.cep = "";
		this.estado = "";
	}


	
	
	
	//getters and setters
	public Integer getId() {
		return idEndereco;
	}
	public void setId(Integer id) {
		this.idEndereco = id;
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
