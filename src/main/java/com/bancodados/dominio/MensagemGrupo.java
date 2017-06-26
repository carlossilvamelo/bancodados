package com.bancodados.dominio;

import java.sql.Date;

public class MensagemGrupo {

	private int idMensagemGrupo;
	private int idTrabalho;
	private int idRemetente;
	private Date dataHora;
	private String conteudo;
	
	public int getIdMensagemGrupo() {
		return idMensagemGrupo;
	}
	public void setIdMensagemGrupo(int idMensagemGrupo) {
		this.idMensagemGrupo = idMensagemGrupo;
	}
	public int getIdTrabalho() {
		return idTrabalho;
	}
	public void setIdTrabalho(int idTrabalho) {
		this.idTrabalho = idTrabalho;
	}
	public int getIdRemetente() {
		return idRemetente;
	}
	public void setIdRemetente(int idRemetente) {
		this.idRemetente = idRemetente;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}
