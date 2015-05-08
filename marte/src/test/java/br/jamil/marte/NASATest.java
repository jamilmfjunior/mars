package br.jamil.marte;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class NASATest {
	
	@Mock
	private CommandParser commandParser;
	
	private NASA nasa;
	
	@Before
	public void init() throws CommandParserError {
		MockitoAnnotations.initMocks(this);
		nasa = new NASA(new StringReader(
				"5 5\n"+
				"1 2 N\n"+
				"LMLMLMLMM\n"+
				"3 3 E\n"+
				"MMRMMRMRRM\n"), commandParser);
		final CommandCreatePlanalto planalto = mock(CommandCreatePlanalto.class);
		doAnswer(new Answer() {

			public Object answer(InvocationOnMock invocation) throws Throwable {
				return planalto;

			}
			
		}).when(commandParser).parseLine(anyString());
	}
	
	
	@Test
	public void validaChamadaDoParserParaCadaLinha() throws Exception {
		nasa.enviarInstrucoes();
		
		verify(commandParser, times(5)).parseLine(anyString());
	}
	
	@Test
	public void validaDadosEnviadosParaParser() throws Exception {
		String instrucao = "5 5";
		nasa = new NASA(new StringReader(instrucao), commandParser);
		nasa.enviarInstrucoes();
		
		verify(commandParser).parseLine(instrucao);
	}
	
	

}