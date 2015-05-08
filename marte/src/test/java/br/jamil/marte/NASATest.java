package br.jamil.marte;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import br.jamil.marte.command.Command;
import br.jamil.marte.command.CommandCreatePlanalto;
import br.jamil.marte.command.CommandParser;
import br.jamil.marte.command.CommandParserError;

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
		doAnswer(new Answer<Command<?>>() {

			public Command<?> answer(InvocationOnMock invocation) throws Throwable {
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
	
	@Test(expected = InstrucoesException.class)
	public void validaOrdemDasInstrucoesPrimeiraLinhaComoSonda() throws Exception {
		NASA nasaPrimeiraLinha = new NASA(new StringReader("5 5 S\n"), new CommandParser());
		nasaPrimeiraLinha.enviarInstrucoes();
	}
	
	@Test(expected = InstrucoesException.class)
	public void validaOrdemDasInstrucoesPrimeiraLinhaComoMovimentos() throws Exception {
		NASA nasaPrimeiraLinha = new NASA(new StringReader("LMR\n"), new CommandParser());
		nasaPrimeiraLinha.enviarInstrucoes();
	}
	
	

}
