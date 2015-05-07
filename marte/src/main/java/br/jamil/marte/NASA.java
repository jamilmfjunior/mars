package br.jamil.marte;

import java.io.BufferedReader;
import java.io.FileReader;

public class NASA {
	
	CommandParser commandParser;
	
	public void enviarInstrucoes(String file) throws Exception {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		
		
		String linha = fileReader.readLine(); 
		while (linha != null) {
			commandParser.parseLine(linha);

			linha = fileReader.readLine();
		}
		
		fileReader.close();
	}

}
