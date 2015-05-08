package br.jamil.marte;

import java.util.ArrayList;
import java.util.List;

public class CommandMoveSonda implements Command<Sonda> {
	
	private List<String> parametros = new ArrayList<String>(); 

	public CommandMoveSonda(char[] asList) {
		for (char parametro : asList) {
			parametros.add(String.valueOf(parametro));
		}
	}

	public String getParametro(int posicao) {
		return parametros.get(posicao);
	}

	public int getQtdParametros() {
		return parametros.size();
	}

	public Sonda run() {
		return null;
	}
	
	

}
