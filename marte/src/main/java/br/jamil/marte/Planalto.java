package br.jamil.marte;

public class Planalto {
	
	private int maxX = 0;
	private int maxY = 0;
	
	public Planalto(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public int norte(int posicao) {
		return ++posicao;
	}
	
	public int sul(int posicao) {
		return --posicao;
	}
	
	public int leste(int posicao) {
		return ++posicao;
	}
	
	public int oeste(int posicao) {
		return --posicao;
	}

}
