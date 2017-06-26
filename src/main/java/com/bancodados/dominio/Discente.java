package com.bancodados.dominio;

import java.util.Calendar;
import java.util.List;


public class Discente extends Usuario{

	
	// pode virar um enum
	private Integer idTrabalho;
	private String matricula;
	private String reputacao;
	
	//construtores
	
	
	public Discente() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getters and setters
	

	public String getReputacao() {
		return reputacao;
	}
	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public void setReputacao(String reputacao) {
		this.reputacao = reputacao;
	}

	public Integer getIdTrabalho() {
		return idTrabalho;
	}

	public void setIdTrabalho(Integer idTrabalho) {
		this.idTrabalho = idTrabalho;
	}
	
	
	
}
