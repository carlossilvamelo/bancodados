package com.bancodados.dominio;

import java.sql.Date;

public class Atividade {

	private Integer IdAtividade;
	private Integer idParticipante;
	private Date prazo;
	public Integer getIdAtividade() {
		return IdAtividade;
	}

	public void setIdAtividade(Integer idAtividade) {
		IdAtividade = idAtividade;
	}

	public Integer getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Integer idParticipante) {
		this.idParticipante = idParticipante;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
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
