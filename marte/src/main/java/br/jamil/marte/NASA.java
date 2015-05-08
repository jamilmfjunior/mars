package br.jamil.marte;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.jamil.marte.command.CommandParserError;

public class NASA {
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("sintaxe: br.jamil.marte.NASA filename.txt");
			System.exit(1);
		}
		try {
			new Processador(args[0]).enviarInstrucoes();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
		} catch (CommandParserError e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstrucoesException e) {
			System.out.println(e.getMessage());
		}
			
	}
	
}
