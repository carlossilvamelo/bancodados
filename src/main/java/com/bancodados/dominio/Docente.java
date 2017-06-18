package com.bancodados.dominio;

import java.util.Calendar;
import java.util.List;



public class Docente extends Usuario{
	
	private List<String> areasPesquisa;
	
	
	
	//construtores

	
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
