package com.bancodados.dominio;


import java.util.Date;


public class Atividade {

	private Integer atividadeId;
	private Date prazo;
	private Integer status; // vira um Enum
	private String descricao;
	private String observacao;
	
	
	
	public Atividade(Date prazo, int status, String descricao, String observacao) {
		this.prazo = prazo;
		this.status = status;
		this.descricao = descricao;
		this.observacao = observacao;
	}
	
	public Atividade() {
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters
	public Integer getId() {
		return atividadeId;
	}
	public void setId(Integer id) {
		this.atividadeId = id;
	}
	public Date getPrazo() {
		return prazo;
	}
	public void setPrazo(Date date) {
		this.prazo = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
	
}
