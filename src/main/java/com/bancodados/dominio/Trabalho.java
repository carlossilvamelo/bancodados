package com.bancodados.dominio;

import java.util.List;


public class Trabalho {

	
	private Integer trabalhoId;
	private String titulo;
	private List<String> areasConhecimento;
	private List<Usuario> participantes;
	private String avaliacao;
	
	//contrutores
	public Trabalho(String titulo, List<String> areasCOnhecimento, List<Usuario> participantes,
			String avaliacao) {
		super();
		this.titulo = titulo;
		this.areasConhecimento = areasCOnhecimento;
		this.participantes = participantes;
		this.avaliacao = avaliacao;
	}
	
	public Trabalho() {
		// TODO Auto-generated constructor stub
	}

	
	//getters and setters
	public Integer getId() {
		return trabalhoId;
	}

	public void setId(Integer id) {
		this.trabalhoId = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getAreasCOnhecimento() {
		return areasConhecimento;
	}

	public void setAreasCOnhecimento(List<String> areasCOnhecimento) {
		this.areasConhecimento = areasCOnhecimento;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
	
	
	
}
