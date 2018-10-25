package com.elissonsilva.lanchonete.layout;

import com.elissonsilva.lanchonete.estrutura.LanIngrediente;

public class LanLayoutIngrediente extends LanLayoutBasic {
	
	private LanIngrediente ingrediente;
	
	public LanLayoutIngrediente(LanIngrediente ingrediente) {
		super();
		this.ingrediente = ingrediente;
	}
	public String mostraLinha() {
		
		String html = "<tr>";
		html += "<td>"+ingrediente.getNome()+"</td>";
		html += "<td>"+formataMoeda(ingrediente.getValor())+"</td>";
		html += "</tr>";
		
		return html;
	}
	
    public String mostraOpcao() {
		
		String html = "<option>" + ingrediente.getNome() + "</option>";
		
		return html;
	}

}
