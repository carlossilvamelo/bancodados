package com.bancodados.dominio;

public enum StatusAtividade {
	EM_ANDAMENTO(0, "em andamento"),
	CONCLUIDO(1, "concluido");
	
	private int valor;
	private String nome;
	
	private StatusAtividade(int valor, String nome){
		this.valor = valor;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	public int getValor(){
		return this.valor;
	}
	
	public static StatusAtividade getStatusByNome(String nome_status){
		StatusAtividade[] valores = StatusAtividade.values();
		StatusAtividade status = null;
		for(StatusAtividade cadaStatus : valores){
			if(cadaStatus.toString() == nome_status){
				status = cadaStatus;
				break;
			}
		}
		return status;
	}
	
	public static StatusAtividade getStatusByValor (int valorStatus){
		StatusAtividade[] valores = StatusAtividade.values();
		StatusAtividade status = null;
		for(StatusAtividade cadaStatus : valores){
			if(cadaStatus.getValor() == valorStatus){
				status = cadaStatus;
				break;
			}
		}
		return status;
	}
}
