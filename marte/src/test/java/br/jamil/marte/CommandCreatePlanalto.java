package br.jamil.marte;

import java.util.ArrayList;
import java.util.List;

public class CommandCreatePlanalto implements Command<Planalto> {
	
	private List<String> parametros = new ArrayList<String>();

	public CommandCreatePlanalto(List<String> asList) {
		parametros.addAll(asList);
	}

	public String getParametro(int posicao) {
		return parametros.get(posicao);
	}
	
	public int getQtdParametros() {
		return parametros.size();
	}

	public Planalto run() {
		return new Planalto(Integer.parseInt(parametros.get(0)), Integer.parseInt(parametros.get(1)));
	}

}
