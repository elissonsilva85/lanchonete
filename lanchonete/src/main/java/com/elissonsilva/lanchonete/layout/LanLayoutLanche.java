package com.elissonsilva.lanchonete.layout;

import java.util.Iterator;

import com.elissonsilva.lanchonete.estrutura.LanIngrediente;
import com.elissonsilva.lanchonete.estrutura.LanLanche;

public class LanLayoutLanche extends LanLayoutBasic {
	
	private LanLanche lanche;
	
	public LanLayoutLanche(LanLanche lanche) {
		super();
		this.lanche = lanche;
	}
	public String mostraLinha() {
		
		String html = "<tr>";
		html += "<td>"+lanche.getNome()+"</td>";
		html += "<td>"+mostraIngredientes()+"</td>";
		html += "<td>"+formataMoeda(lanche.getPrecoIngredientes())+"</td>";
		html += "</tr>";
		
		return html;
	}
	public String mostraIngredientes() {
		
		String retorno = "";
		Iterator<LanIngrediente> ingredientes = lanche.getIngredientes().iterator();
		while(ingredientes.hasNext())
		{
			if(!retorno.isEmpty()) retorno  += ", ";
			retorno += ingredientes.next().getNome(); 
		}
		
		return retorno;
	}
	public String getPreco() {
		return formataMoeda(lanche.getPrecoPromocao());
	}
	public String getDesconto() {
		double desconto = lanche.getPrecoIngredientes() - lanche.getPrecoPromocao();
		
		return (desconto > 0 ? formataMoeda(desconto) : "" );
	}

}
