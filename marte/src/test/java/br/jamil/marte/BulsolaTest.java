package br.jamil.marte;

import static junit.framework.Assert.*;

import org.junit.Test;

public class BulsolaTest {
	
	@Test
	public void validaDirecao() {
		assertEquals(Direcao.Norte, new Bulsola(Direcao.Norte).getDirecao());
	}
	
	@Test
	public void virarADireita() {
		assertEquals(Direcao.Leste, new Bulsola(Direcao.Norte).virarParaDireita());
	}
	
	@Test
	public void virarAEsquerda() {
		assertEquals(Direcao.Oeste, new Bulsola(Direcao.Norte).virarParaEsquerda());
	}
	
	@Test
	public void virarDuasVezesParaDireira() {
		Bulsola bulsola = new Bulsola(Direcao.Norte);
		bulsola.virarParaDireita();
		bulsola.virarParaDireita();
		assertEquals(Direcao.Sul, bulsola.getDirecao());
	}
	
	@Test 
	public void virarDuasVezesParaEsquerda() {
		Bulsola bulsola = new Bulsola(Direcao.Norte);
		bulsola.virarParaEsquerda();
		bulsola.virarParaEsquerda();
		assertEquals(Direcao.Sul, bulsola.getDirecao());
	}
	
	@Test 
	public void virarTresVezesParaEsquerda() {
		Bulsola bulsola = new Bulsola(Direcao.Norte);
		bulsola.virarParaEsquerda();
		bulsola.virarParaEsquerda();
		bulsola.virarParaEsquerda();
		assertEquals(Direcao.Leste, bulsola.getDirecao());
	}
	
	@Test
	public void virarTresVezesParaDireira() {
		Bulsola bulsola = new Bulsola(Direcao.Norte);
		bulsola.virarParaDireita();
		bulsola.virarParaDireita();
		bulsola.virarParaDireita();
		assertEquals(Direcao.Oeste, bulsola.getDirecao());
	}
	
	@Test
	public void darVoltaCompletaParaDireita() {
		Bulsola bulsola = new Bulsola(Direcao.Norte);
		bulsola.virarParaDireita();
		bulsola.virarParaDireita();
		bulsola.virarParaDireita();
		bulsola.virarParaDireita();
		assertEquals(Direcao.Norte, bulsola.getDirecao());
	}
	

	@Test 
	public void darVoltaCompletaParaEsquerda() {
		Bulsola bulsola = new Bulsola(Direcao.Norte);
		bulsola.virarParaEsquerda();
		bulsola.virarParaEsquerda();
		bulsola.virarParaEsquerda();
		bulsola.virarParaEsquerda();
		assertEquals(Direcao.Norte, bulsola.getDirecao());
	}
	
	

}
