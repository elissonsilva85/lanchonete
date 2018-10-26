package com.elissonsilva.lanchonete;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.elissonsilva.lanchonete.estrutura.LanEstrutura;
import com.elissonsilva.lanchonete.estrutura.LanException;
import com.elissonsilva.lanchonete.estrutura.LanIngrediente;
import com.elissonsilva.lanchonete.estrutura.LanLanche;
import com.elissonsilva.lanchonete.negocio.LanMontaLanche;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LanLanchoneteTest {

	private String nomeIngredienteDeTeste = "IngredienteDeTeste";
	
	@Test
	public void test_000_PreparaEstrutura() {
		
		try {
			LanEstrutura.addIngrediente(new LanIngrediente(LanEstrutura.ALFACE, 1));
			LanEstrutura.addIngrediente(new LanIngrediente(LanEstrutura.BACON, 2));
			LanEstrutura.addIngrediente(new LanIngrediente(LanEstrutura.OVO, 3));
			LanEstrutura.addIngrediente(new LanIngrediente(LanEstrutura.HAMBURGUER, 4));
			LanEstrutura.addIngrediente(new LanIngrediente(LanEstrutura.QUEIJO, 5));
		} catch(LanException e) {
			Assert.fail("Ocorreu uma falha: " + e.getMessage());
		}
		
		Assert.assertNotNull(LanEstrutura.getIngrediente(LanEstrutura.ALFACE));
		Assert.assertNotNull(LanEstrutura.getIngrediente(LanEstrutura.BACON));
		Assert.assertNotNull(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER));
		Assert.assertNotNull(LanEstrutura.getIngrediente(LanEstrutura.OVO));
		Assert.assertNotNull(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO));
	}	
	
	@Test
	public void test_001_IngredienteDuplicado() {
		
		try {
			LanEstrutura.addIngrediente(new LanIngrediente(nomeIngredienteDeTeste, 10));
		} catch(LanException e) {
			Assert.fail("Ocorreu uma falha: " + e.getMessage());
		}
		
		try {		
			LanEstrutura.addIngrediente(new LanIngrediente(nomeIngredienteDeTeste, 20));
			Assert.fail("Deixou adicionar dois ingredientes " + nomeIngredienteDeTeste + " com o mesmo nome");
		} catch(LanException e) {
		}
		
		Assert.assertEquals(10, LanEstrutura.getIngrediente(nomeIngredienteDeTeste).getValor(), 0);
	}
	
	@Test
	public void test_002_AtualizaValor() {
		
		//
		// Valor Original
		//
		Assert.assertEquals(10, LanEstrutura.getIngrediente(nomeIngredienteDeTeste).getValor(), 0);
		
		//
		// Atualiza Valor
		//
		LanEstrutura.getIngrediente(nomeIngredienteDeTeste).setValor(20);
		Assert.assertEquals(20, LanEstrutura.getIngrediente(nomeIngredienteDeTeste).getValor(), 0);
	}

	@Test
	public void test_003_ValorIngredientes() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(7, lanche.getPrecoIngredientes(), 0);
	}
	
	@Test
	public void test_004_SemPromocao() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(6, lanche.getPrecoPromocao(), 0);
		
	}
	
	@Test
	public void test_005_PromocaoLight() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(4.5, lanche.getPrecoPromocao(), 0);		
	}
	
	@Test
	public void test_006_PromocaoMuitaCarne2() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(11, lanche.getPrecoPromocao(), 0);		
	}

	@Test
	public void test_007_PromocaoMuitaCarne3() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(11, lanche.getPrecoPromocao(), 0);		
	}
	
	@Test
	public void test_008_PromocaoMuitaCarne4() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(15, lanche.getPrecoPromocao(), 0);		
	}
	
	@Test
	public void test_008_PromocaoMuitaCarne6() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(19, lanche.getPrecoPromocao(), 0);		
	}
	
	@Test
	public void test_009_PromocaoMuitoQueijo2() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(13, lanche.getPrecoPromocao(), 0);		
	}

	@Test
	public void test_010_PromocaoMuitoQueijo3() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(13, lanche.getPrecoPromocao(), 0);		
	}
	
	@Test
	public void test_011_PromocaoMuitoQueijo4() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(18, lanche.getPrecoPromocao(), 0);		
	}
	
	@Test
	public void test_011_PromocaoMuitoQueijo6() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.BACON)); // 2
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(23, lanche.getPrecoPromocao(), 0);		
	}
	
	@Test
	public void test_012_PromocaoLightMuitaCarneMuitoQueijo() {

		ArrayList<LanIngrediente> ingredientes = new ArrayList<LanIngrediente>();
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.ALFACE)); // 1
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.OVO)); // 3
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.HAMBURGUER)); // 4
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		ingredientes.add(LanEstrutura.getIngrediente(LanEstrutura.QUEIJO)); // 5
		
		LanLanche lanche = new LanLanche("X-Teste", ingredientes);
		
		Assert.assertEquals(19.8, lanche.getPrecoPromocao(), 0); // Total 22 - 10% = 19.8		
	}
	
	@Test
	public void test_013_MontaLanche0() {
		
		LanMontaLanche montaLanche = new LanMontaLanche();
		
		montaLanche.defineIngredientes("[{\"nome\":\"\",\"qtde\":null}]");
		
		LanLanche lanche = montaLanche.retornaLanche();
		
		Assert.assertNotNull(lanche);		
		Assert.assertEquals(0, lanche.getIngredientes().size());
	}
	
	@Test
	public void test_013_MontaLanche1() {
		
		LanMontaLanche montaLanche = new LanMontaLanche();
		
		montaLanche.defineIngredientes("[{\"nome\":\"Alface\",\"qtde\":1}]");
		
		LanLanche lanche = montaLanche.retornaLanche();
		
		Assert.assertNotNull(lanche);		
		Assert.assertEquals(1, lanche.getIngredientes().size());
	}
	
	@Test
	public void test_013_MontaLanche2() {
		
		LanMontaLanche montaLanche = new LanMontaLanche();
		
		montaLanche.defineIngredientes("[{\"nome\":\"Alface\",\"qtde\":1}, {\"nome\":\"Bacon\",\"qtde\":2}]");
		
		LanLanche lanche = montaLanche.retornaLanche();
		
		Assert.assertNotNull(lanche);		
		Assert.assertEquals(3, lanche.getIngredientes().size());
	}

}
