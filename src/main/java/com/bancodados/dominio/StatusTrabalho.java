package com.bancodados.dominio;

public enum StatusTrabalho {
	EM_ANDAMENTO(0, "em andamento"),
	CONLCUIDO(1, "concluido");
	
	private int valor;
	private String nome;
	
	private StatusTrabalho(int valor, String nome){
		this.valor = valor;
		this.nome = nome;
	}
	
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	public static StatusTrabalho getStatusByNome(String nome_status){
		StatusTrabalho[] valores = StatusTrabalho.values();
		StatusTrabalho status = null;
		for(StatusTrabalho cadaStatus : valores){
			if(cadaStatus.toString() == nome_status)
				status = cadaStatus;
		}
		return status;
	}
}
