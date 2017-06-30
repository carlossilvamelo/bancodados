package com.bancodados.dominio;

import java.sql.Date;
import java.util.ArrayList;

public class Atividade {

	private Integer IdAtividade;
	private Integer idTrabalho;
	private Date prazo;
	private StatusAtividade status = StatusAtividade.EM_ANDAMENTO;
	private String descricao;
	private String observacao;
	private ArrayList<Discente> participantes = new ArrayList<Discente>();
	
	public Integer getIdAtividade() {
		return IdAtividade;
	}

	public void setIdAtividade(Integer idAtividade) {
		IdAtividade = idAtividade;
	}

	public Integer getIdTrabalho() {
		return idTrabalho;
	}

	public void setIdTrabalho(Integer idParticipante) {
		this.idTrabalho = idParticipante;
	}

	public void setStatus(int status) {
		this.status = StatusAtividade.getStatusByValor(status);
	}
	
	public Atividade(Date prazo, int status, String descricao, String observacao) {
		this.prazo = prazo;
		this.status = StatusAtividade.getStatusByValor(status);
		this.descricao = descricao;
		this.observacao = observacao;
	}
	
	public Atividade() {
	}
	
	//getters and setters
	
	public Date getPrazo() {
		return prazo;
	}
	public void setPrazo(Date date) {
		this.prazo = date;
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

	public StatusAtividade getStatus() {
		return status;
	}

	public void setStatus(StatusAtividade status) {
		this.status = status;
	}

	public ArrayList<Discente> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Discente> participantes) {
		this.participantes = participantes;
	}
	
	public void adicionarParticipante(Discente dis){
		this.participantes.add(dis);
	}
	
	public void removerParticipante(Discente dis){
		this.participantes.remove(dis);
	}
	
	
}
