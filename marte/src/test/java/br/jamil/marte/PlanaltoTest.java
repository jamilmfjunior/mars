package br.jamil.marte;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlanaltoTest {
	
	private static final int LIMITEX = 5;
	private static final int LIMITEY = 5;
	
	private Planalto planalto = new Planalto(5, 5);
	
	@Test
	public void testarMovimentoParaLeste() {
		assertEquals(2, planalto.leste(1));
	}
	
	@Test
	public void testarMovimentoParaLesteAlemDoPlanalto() {
		assertEquals(LIMITEX, planalto.leste(LIMITEX));
	}
	
	@Test
	public void testarMovimentoParaOeste() {
		assertEquals(0, planalto.oeste(1));
	}
	
	@Test
	public void testarMovimentoParaOesteAlemDoPlanalto() {
		assertEquals(0, planalto.oeste(0));
	}
	
	@Test
	public void testarMovimentoParaNorte() {
		assertEquals(1, planalto.norte(0));
	}
	
	@Test
	public void testarMovimentoParaNorteAlemDoPlanalto() {
		assertEquals(LIMITEY, planalto.norte(LIMITEY));
	}
	
	@Test
	public void testarMovimentoParaSul() {
		assertEquals(4, planalto.sul(LIMITEY));
	}
	
	@Test
	public void testarMovimentoParaSulAlemDoPlanalto() {
		assertEquals(0, planalto.sul(0));
	}

}
