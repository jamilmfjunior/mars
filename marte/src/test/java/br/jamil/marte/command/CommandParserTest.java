package br.jamil.marte.command;

import static org.junit.Assert.*;

import org.junit.Test;

import br.jamil.marte.Planalto;
import br.jamil.marte.Sonda;
import br.jamil.marte.bulsola.Direcao;
import br.jamil.marte.command.Command;
import br.jamil.marte.command.CommandCreatePlanalto;
import br.jamil.marte.command.CommandCreateSonda;
import br.jamil.marte.command.CommandMoveSonda;
import br.jamil.marte.command.CommandParser;
import br.jamil.marte.command.CommandParserError;

public class CommandParserTest {
	
	@Test
	public void parseInformacaoPlanalto() throws Exception {
		CommandParser parser = new CommandParser();
		Command<?> command = parser.parseLine("5 5");
		
		assertTrue(command instanceof CommandCreatePlanalto);
	}
	
	@Test(expected = CommandParserError.class)
	public void parseInformacaoLinhaVazia() throws Exception {
		CommandParser parser = new CommandParser();
		parser.parseLine("");
	}
	
	@Test(expected = CommandParserError.class) 
	public void parseInformacaoLinhaFormatoInvalido() throws Exception {
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
	
	@Test 
	public void parseInformacaoSonda() throws Exception {
		CommandParser parser = new CommandParser();
		Command<?> command = parser.parseLine("10 1 N");
		
		assertTrue(command instanceof CommandCreateSonda);
	}
	
	@Test(expected = CommandParserError.class) 
	public void parseInformacaoSondaTipoValorInvalido() throws Exception {
		CommandParser parser = new CommandParser();
		parser.parseLine("5 5 R");
	}
	
	@Test
	public void validaParametrosSonda() throws Exception {
		CommandParser parser = new CommandParser();
		Command<?> command = parser.parseLine("1 2 S");
		
		Sonda sonda = (Sonda) command.run();
		
		assertEquals(1, sonda.getEixoX());
		assertEquals(2, sonda.getEixoY());
		assertEquals(Direcao.Sul, sonda.getPosicao());
	}
	
	@Test
	public void parseInformacaoMovimento() throws Exception {
		CommandParser parser = new CommandParser();
		Command<?> command = parser.parseLine("LMRLLL");
		
		assertTrue(command instanceof CommandMoveSonda);
	}
	
	@Test(expected = CommandParserError.class) 
	public void parseInformacaoMovimentoInválida() throws Exception {
		CommandParser parser = new CommandParser();
		parser.parseLine("LMX");
	}
	
	@Test
	public void validaMovimento() throws Exception {
		CommandParser parser = new CommandParser();
		Command<?> command =  parser.parseLine("LMR");
		
		assertEquals("L", command.getParametro(0));
		assertEquals("M", command.getParametro(1));
		assertEquals("R", command.getParametro(2));
	}
	
}
