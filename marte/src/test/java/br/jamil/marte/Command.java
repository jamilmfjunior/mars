package br.jamil.marte;


public interface Command<T> {
	
	String getParametro(int posicao);

	int getQtdParametros();
	
	T run();

}
