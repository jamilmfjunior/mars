package br.jamil.marte.command;


public interface Command<T> {
	
	String getParametro(int posicao);

	int getQtdParametros();
	
	T run();

}
