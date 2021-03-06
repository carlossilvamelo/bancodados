package com.bancodados.dominio;

import java.util.ArrayList;


public class Trabalho {

	
	private Integer idTrabalho;
	private String titulo;
	private String resumo;
	private Integer curtidas;
	private StatusTrabalho status;
	
	private ArrayList<Discente> participantes;
	
	public Integer getIdTrabalho() {
		return idTrabalho;
	}
	public void setIdTrabalho(Integer idTrabalho) {
		this.idTrabalho = idTrabalho;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Integer getCurtidas() {
		return curtidas;
	}
	public void setCurtidas(Integer curtidas) {
		this.curtidas = curtidas;
	}
	public StatusTrabalho getStatus() {
		return status;
	}
	public void setStatus(StatusTrabalho status) {
		this.status = status;
	}
	public ArrayList<Discente> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(ArrayList<Discente> participantes) {
		this.participantes = participantes;
	}
	
	public void adicionarParticipante(Discente discente){
		this.participantes.add(discente);
	}
	
	public void removerParticipante(Discente discente){
		this.participantes.remove(discente);
	}
	
}
