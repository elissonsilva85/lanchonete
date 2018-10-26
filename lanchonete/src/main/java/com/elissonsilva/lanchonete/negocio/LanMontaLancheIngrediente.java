package com.elissonsilva.lanchonete.negocio;

public class LanMontaLancheIngrediente {

	private String nome;
	private int qtde;
	
	public LanMontaLancheIngrediente() {
	}

	public String getNome() {
		return nome;
	}

	public int getQtde() {
		return qtde;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQtde(int qtde) {
		this.qtde = (qtde < 0 ? 0 : qtde);
	}
	
	
}
