package com.elissonsilva.lanchonete.estrutura;

import java.util.ArrayList;
import java.util.HashMap;

public class LanEstrutura {

	private static HashMap<String,LanIngrediente> todosIngredientes;
	
	private static HashMap<String,LanLanche> todosLanches;
	
	private static boolean estruturaCriada = false;
	
	public static String ALFACE = "Alface";
	public static String BACON = "Bacon";
	public static String HAMBURGUER = "Hamburguer de Carne";
	public static String OVO = "Ovo";
	public static String QUEIJO = "Queijo";
			
	public static void addIngrediente(LanIngrediente ingrediente) throws LanException {
		if(todosIngredientes == null)
			todosIngredientes = new HashMap<String, LanIngrediente>();
		
		if(todosIngredientes.containsKey(ingrediente.getNome()))
		{
			throw new LanException("Já existe um ingrediente com o nome " + ingrediente.getNome() + ".");
		}
		
		todosIngredientes.put(ingrediente.getNome(), ingrediente);
	}
	
	public static LanIngrediente getIngrediente(String nome) {
		return (nome == null ? null : todosIngredientes.get(nome));
	}
	
	public static ArrayList<LanIngrediente> getIngredientes() {
		return new ArrayList<LanIngrediente>(todosIngredientes.values());
	}
	
	public static void alterarValor(String nome, double novoValor) throws LanException{
		
		LanIngrediente ingrediente = getIngrediente(nome);
		
		if(ingrediente == null) {
			addIngrediente(new LanIngrediente(nome, novoValor));
		}
		else {
			ingrediente.setValor(novoValor);
		}
		
	}

	public static void addLanche(LanLanche lanche) throws LanException {
		if(todosLanches == null)
			todosLanches = new HashMap<String, LanLanche>();
		
		if(todosLanches.containsKey(lanche.getNome()))
		{
			throw new LanException("Já existe um lanche com o nome " + lanche.getNome() + ".");
		}
		
		todosLanches.put(lanche.getNome(), lanche);
	}
	
	public static ArrayList<LanLanche> getLanches() {
		return new ArrayList<LanLanche>(todosLanches.values());
	}
	
	public static void preparaEstruturaInicial() throws LanException {
		
		if(estruturaCriada) return;
		
		estruturaCriada = true;
		
		addIngrediente(new LanIngrediente(ALFACE,0.4));
		addIngrediente(new LanIngrediente(BACON,2.0));
		addIngrediente(new LanIngrediente(HAMBURGUER,3.0));
		addIngrediente(new LanIngrediente(OVO,0.8));
		addIngrediente(new LanIngrediente(QUEIJO,1.5));
		
		LanLanche lanche = null;
		
		// X-Bacon
		lanche = new LanLanche("X-Bacon");
		lanche.addIngrediente(getIngrediente(BACON));
		lanche.addIngrediente(getIngrediente(HAMBURGUER));
		lanche.addIngrediente(getIngrediente(QUEIJO));
		addLanche(lanche);

		// X-Burguer
		lanche = new LanLanche("X-Burguer");
		lanche.addIngrediente(getIngrediente(HAMBURGUER));
		lanche.addIngrediente(getIngrediente(QUEIJO));
		addLanche(lanche);

		// X-Egg
		lanche = new LanLanche("X-Egg");
		lanche.addIngrediente(getIngrediente(OVO));
		lanche.addIngrediente(getIngrediente(HAMBURGUER));
		lanche.addIngrediente(getIngrediente(QUEIJO));
		addLanche(lanche);
		
		// X-Egg Bacon
		lanche = new LanLanche("X-Egg Bacon");
		lanche.addIngrediente(getIngrediente(OVO));
		lanche.addIngrediente(getIngrediente(BACON));
		lanche.addIngrediente(getIngrediente(HAMBURGUER));
		lanche.addIngrediente(getIngrediente(QUEIJO));
		addLanche(lanche);

	}
	
}
