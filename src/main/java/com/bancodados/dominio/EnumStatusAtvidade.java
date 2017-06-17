package com.bancodados.dominio;

public enum EnumStatusAtvidade {

	PENDENTE("Pendente"),
	EM_ANDAMENTO("Em andamento"),
	EM_REVISAO("Em revisão"),
	FINALIZADA("Finalizada"),
	POSTADA("Postada");
	
	private String nome;
	
	private EnumStatusAtvidade(String nome) {
		this.nome = nome;
	}
}
