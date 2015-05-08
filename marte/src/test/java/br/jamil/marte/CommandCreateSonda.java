package br.jamil.marte;

import java.util.ArrayList;
import java.util.List;

public class CommandCreateSonda implements Command<Sonda> {
	
	private List<String> parametros = new ArrayList<String>();

	public CommandCreateSonda(List<String> asList) {
		this.parametros.addAll(asList);
	}
	
	public String getParametro(int posicao) {
		return parametros.get(posicao);
	}

	public int getQtdParametros() {
		return parametros.size();
	}

	public Sonda run() {
		return new Sonda(Integer.parseInt(getParametro(0)), Integer.parseInt(getParametro(1)), 
				new Bulsola(Direcao.valueToDirection(getParametro(2))), new Planalto(5, 5));
	}

}
