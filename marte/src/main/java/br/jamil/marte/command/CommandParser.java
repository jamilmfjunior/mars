package br.jamil.marte.command;

import java.util.Arrays;

public class CommandParser {

	public Command<?> parseLine(String linha) throws CommandParserError {
		if (linha.matches("\\d* \\d*")) {
			return new CommandCreatePlanalto(Arrays.asList(linha.split("\\s")));
		} else if (linha.matches("\\d* \\d* [NSEW]")) {
			return new CommandCreateSonda(Arrays.asList(linha.split("\\s")));
		} else if (linha.matches("[LRM]+")) {
			return new CommandMoveSonda(linha.toCharArray());
		} else {
			throw new CommandParserError();
		}
	}

}
