package com.elissonsilva.lanchonete.estrutura;

import java.util.ArrayList;
import java.util.Iterator;

import com.elissonsilva.lanchonete.negocio.LanPromocao;

public class LanLanche {

	private String nome;
	
	private ArrayList<LanIngrediente> ingredientes;

	public LanLanche(String nome) {
		this(nome, new ArrayList<LanIngrediente>());
	}

	public LanLanche(String nome, ArrayList<LanIngrediente> ingredientes) {
		this.nome = nome;
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<LanIngrediente> getIngredientes() {
		return ingredientes;
	}
	
	public void setIngredientes(ArrayList<LanIngrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void addIngrediente(LanIngrediente ingrediente) {
		addIngrediente(ingrediente, 1);
	}
	
	public void addIngrediente(LanIngrediente ingrediente, int qtde) {
		
		if(qtde < 0) qtde = 0;
		
		for(int i = 0; i < qtde; i++)
			ingredientes.add(ingrediente);
	}
	
	public double getPrecoIngredientes() {
			
		float preco = 0;
		
		Iterator<LanIngrediente> it = ingredientes.iterator();
		while (it.hasNext()) {
		    preco += it.next().getValor();
		}		
		
		return preco;			
	}
	
	public double getPrecoPromocao() {
		
		return LanPromocao.getPreco(this);		
	}

}
