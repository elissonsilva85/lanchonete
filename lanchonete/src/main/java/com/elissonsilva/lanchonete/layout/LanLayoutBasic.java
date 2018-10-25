package com.elissonsilva.lanchonete.layout;

public abstract class LanLayoutBasic {

	protected String formataMoeda(double valor) {
		
		return String.format("R$ %.2f", valor);
		
	}
	
}
