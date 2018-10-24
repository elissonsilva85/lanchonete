package com.elissonsilva.lanchonete.negocio;

import java.util.Iterator;

import com.elissonsilva.lanchonete.estrutura.LanEstrutura;
import com.elissonsilva.lanchonete.estrutura.LanIngrediente;
import com.elissonsilva.lanchonete.estrutura.LanLanche;

public class LanPromocao {

	public static double getPreco(LanLanche lanche) {
		
		//
		// Inicia com o valor do lanche baseado no valor de cada ingrediente
		//
		double valorFinal = lanche.getPrecoIngredientes();
		
		//
		// Variaveis de apoio para identificar promoções
		//
		boolean temAlface = false;
		boolean temBacon = false;
		int qtdeCarne = 0;
		int qtdeQueijo = 0;
		
		//
		// Percorre os ingrediente e popula variaveis de apoio
		//
		Iterator<LanIngrediente> it = lanche.getIngredientes().iterator();
		while (it.hasNext()) {
			LanIngrediente ingrediente = it.next();
			
			if(ingrediente.getNome().equals(LanEstrutura.ALFACE)) {
				temAlface = true; 
			}

			if(ingrediente.getNome().equals(LanEstrutura.BACON)) {
				temBacon = true; 
			}

			if(ingrediente.getNome().equals(LanEstrutura.HAMBURGUER)) {
				qtdeCarne++;
			}
			
			if(ingrediente.getNome().equals(LanEstrutura.QUEIJO)) {
				qtdeQueijo++;
			}
			
		}
		
		//
		// Se for multiplo de 3 então faz a contas dos descontos de carne e queijo
		//
		double precoCarne = 0;
		double precoQueijo = 0;
		
		try {
			precoCarne = LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER).getValor();
		} catch(Exception e) {
		}

		try {
			precoQueijo = LanEstrutura.getIngrediente(LanEstrutura.QUEIJO).getValor();
		} catch(Exception e) {
		}

		if(qtdeCarne%3 == 0)
		{
			int qtdeDesconto = qtdeCarne/3;
			valorFinal -= qtdeDesconto * precoCarne;
		}
		
		if(qtdeQueijo%3 == 0)
		{
			int qtdeDesconto = qtdeQueijo/3;
			valorFinal -= qtdeDesconto * precoQueijo;
		}
		
		//
		// Verifica se é a promoção do lanche Ligth
		//
		if(temAlface && !temBacon)
		{
			valorFinal = valorFinal * 0.9;
		}
		
		return valorFinal;
		
	}
	
}
