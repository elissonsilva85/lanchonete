package com.elissonsilva.lanchonete.layout;

import java.util.Iterator;

import com.elissonsilva.lanchonete.estrutura.LanEstrutura;
import com.elissonsilva.lanchonete.estrutura.LanIngrediente;
import com.elissonsilva.lanchonete.estrutura.LanLanche;

public class LanLayout {

	public String mostraIngredientes() {
		
		String tabela = "<table class=\"table table-hover table-sm\">";
		
		tabela += "<thead><tr>";
		tabela += "  <th>Ingrediente</th>";
		tabela += "  <th>Valor</th>";
		tabela += "</tr></thead>";
		tabela += "<tbody>";
		
		Iterator<LanIngrediente> ingredientes = LanEstrutura.getIngredientes().iterator();
		while(ingredientes.hasNext())
		{
			LanLayoutIngrediente layout = new LanLayoutIngrediente(ingredientes.next());
			tabela += layout.mostraLinha();
		}
		
		tabela += "</tbody></table>";
		
		return tabela;
	}
	
	public String mostraOpcoesIngredientes() {
		
		String opcoes = "[";
		
		Iterator<LanIngrediente> ingredientes = LanEstrutura.getIngredientes().iterator();
		while(ingredientes.hasNext())
		{
			if(opcoes.length() > 1) opcoes += ", ";
			
			LanLayoutIngrediente layout = new LanLayoutIngrediente(ingredientes.next());
			opcoes += layout.mostraOpcao();
		}
		
		opcoes += "]";
		
		return opcoes;
	}
	
	
	
	public String mostraLanches() {
		
		String tabela = "<table class=\"table table-hover table-sm\">";
		
		tabela += "<thead><tr>";
		tabela += "  <th>Lanche</th>";
		tabela += "  <th colspan=\"2\">Ingredientes</th>";
		tabela += "</tr></thead>";
		tabela += "<tbody>";
		
		Iterator<LanLanche> lanches = LanEstrutura.getLanches().iterator();
		while(lanches.hasNext())
		{
			LanLayoutLanche layout = new LanLayoutLanche(lanches.next());
			tabela += layout.mostraLinha();
		}
		
		tabela += "</tbody></table>";
		
		return tabela;
	}
	
	
}
