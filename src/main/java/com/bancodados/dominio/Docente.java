package com.bancodados.dominio;

import java.util.Calendar;
import java.util.List;



public class Docente extends Usuario{
	
	private List<String> areasPesquisa;
	
	
	
	//construtores
	public Docente(String nome, Integer idade, Integer cpf, Endereco endereco, String email,
			String curriculo, Calendar dataNascimento, Identificacao identidicacao, List<String> areasPesquisa,
			List<String> conhecimento) {
		super(nome, idade, cpf, endereco, email, curriculo, dataNascimento, identidicacao);
		this.areasPesquisa = areasPesquisa;
	}
	
	public Docente() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getters e setters
	public List<String> getAreasPesquisa() {
		return areasPesquisa;
	}
	public void setAreasPesquisa(List<String> areasPesquisa) {
		this.areasPesquisa = areasPesquisa;
	}
	
	
	
}
