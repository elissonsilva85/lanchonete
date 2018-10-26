package com.elissonsilva.lanchonete.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.elissonsilva.lanchonete.estrutura.LanEstrutura;
import com.elissonsilva.lanchonete.estrutura.LanLanche;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LanMontaLanche {

	private LanLanche lanche;
	
	public void defineIngredientes(String parametros) {

		lanche = new LanLanche("Personalizado");
		
		try {
			ArrayList<LanMontaLancheIngrediente> ingredientes = new ArrayList<LanMontaLancheIngrediente>(jsonToObjeto(parametros));
			
			Iterator<LanMontaLancheIngrediente> lista = ingredientes.iterator();
			while(lista.hasNext())
			{
				LanMontaLancheIngrediente ingrediente = lista.next();
				lanche.addIngrediente(LanEstrutura.getIngrediente(ingrediente.getNome()), ingrediente.getQtde());
			}			
			
		} catch (JsonParseException e) {
			System.out.println("JsonParseException: " + e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("JsonMappingException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}
	}
	
	public LanLanche retornaLanche() {
		
		return lanche;
		
	}
	
	public List<LanMontaLancheIngrediente> jsonToObjeto(String stringJson) throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return Arrays.asList(mapper.readValue(stringJson, LanMontaLancheIngrediente[].class));
    }
	
}
