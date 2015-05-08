package br.jamil.marte;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SondaTest {
	
	Sonda sonda;
	
	@Before
	public void setup() {
		sonda = new Sonda(1,2, new Bulsola(Direcao.Norte));
		sonda.setPlanalto(new Planalto(5, 5));
		
	}
	
	@Test
	public void pegaPosicao() {
		assertEquals(Direcao.Norte, sonda.getPosicao());
		assertEquals(1, sonda.getEixoX());
		assertEquals(2, sonda.getEixoY());
	}
	
	@Test
	public void moverSonda() {
		sonda.mover();
		assertEquals(3, sonda.getEixoY());
	}
	
	@Test
	public void moverVirarEMoverSonda() {
		sonda.virarAEsquerda();
		sonda.mover();
		assertEquals(Direcao.Oeste, sonda.getPosicao());
		assertEquals(0, sonda.getEixoX());
	}
	
	
	@Test
	public void validacao() {
//		LMLMLMLMM
		sonda.virarAEsquerda();
		sonda.mover();
		sonda.virarAEsquerda();
		sonda.mover();
		sonda.virarAEsquerda();
		sonda.mover();
		sonda.virarAEsquerda();
		sonda.mover();
		sonda.mover();
		assertEquals(1, sonda.getEixoX());
		assertEquals(3, sonda.getEixoY());
		assertEquals(Direcao.Norte, sonda.getPosicao());
	}
	
	@Test
	public void validacao2() {
//		3 3 E
//		MMR MMR MRRM
		Sonda sonda2 = new Sonda(3, 3, new Bulsola(Direcao.Leste));
		sonda2.setPlanalto(new Planalto(5, 5));
		sonda2.mover();
		sonda2.mover();
		assertEquals(5, sonda2.getEixoX());
		assertEquals(3, sonda2.getEixoY());
		sonda2.virarADireita();
		sonda2.mover();
		sonda2.mover();
		sonda2.virarADireita();
		sonda2.mover();
		sonda2.virarADireita();
		sonda2.virarADireita();
		sonda2.mover();
		assertEquals(5, sonda2.getEixoX());
		assertEquals(1, sonda2.getEixoY());
	}
	
}
