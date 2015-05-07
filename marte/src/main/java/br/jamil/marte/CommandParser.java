package br.jamil.marte;

import java.util.Arrays;

public class CommandParser {

	public Command parseLine(String linha) throws CommandParserError {
		if ("".equals(linha) || !linha.matches("\\d* \\d*")) {
			throw new CommandParserError();
		}
		
		return new CommandCreatePlanalto(Arrays.asList(linha.split("\\s")));
	}

}
