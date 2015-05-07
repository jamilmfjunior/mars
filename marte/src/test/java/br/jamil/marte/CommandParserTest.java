package br.jamil.marte;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandParserTest {
	
	@Test
	public void parseInformacaoPlanalto() throws Exception {
		CommandParser parser = new CommandParser();
		Command<?> command = parser.parseLine("5 5");
		
		assertTrue(command instanceof CommandCreatePlanalto);
	}
	
	@Test(expected = CommandParserError.class)
	public void parseInformacaoPlanaltoVazia() throws Exception {
		CommandParser parser = new CommandParser();
		parser.parseLine("");
	}
	
	@Test(expected = CommandParserError.class) 
	public void parseInformacaoPlanaltoFormatoInvalido() throws Exception {
		CommandParser parser = new CommandParser();
		parser.parseLine("5");
	}
	
	@Test(expected = CommandParserError.class) 
	public void parseInformacaoPlanaltoTipoValorInvalido() throws Exception {
		CommandParser parser = new CommandParser();
		parser.parseLine("5 R");
	}
	
	@Test
	public void validaParametrosPlanalto() throws Exception {
		CommandParser parser = new CommandParser();
		Command<?> command = parser.parseLine("5 6");
		
		assertTrue(command instanceof CommandCreatePlanalto);
		assertEquals(2, command.getQtdParametros());
		assertEquals("5", command.getParametro(0));
		assertEquals("6", command.getParametro(1));
	}
	
	@Test
	public void validaCriacaoPlanalto() throws Exception {
		CommandParser parser = new CommandParser();
		Command<?> command = parser.parseLine("5 6");
		Planalto planalto = (Planalto) command.run();
		
		assertEquals(5, planalto.getMaxX());
		assertEquals(6, planalto.getMaxY());
		
	}
	
}
