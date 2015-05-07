package br.jamil.marte;

public class Sonda {

	private Bulsola bulsola;
	private Planalto planalto;
	private int x;
	private int y;
	
	public Sonda(int x, int y, Bulsola bulsola, Planalto planalto) {
		this.bulsola = bulsola;
		this.planalto = planalto;
		this.x = x;
		this.y = y;
	}

	public void virarADireita() {
		bulsola.virarParaDireita();
	}
	
	public void virarAEsquerda() {
		bulsola.virarParaEsquerda();
	}
	
	public Direcao getPosicao() {
		return bulsola.getDirecao();
	}
	
	public void mover() {
		switch (bulsola.getDirecao()) {
		case Norte:
			moverParaNorte();
			break;
		case Oeste:
			moverParaOeste();
			break;
		case Sul:
			moverParaSul();
			break;
		case Leste:
			moverParaLeste();
			break;
		
		default:
			break;
		}   
	}

	private void moverParaOeste() {
		x = planalto.oeste(x);
		
	}

	private void moverParaLeste() {
		x = planalto.leste(x);
		
	}

	private void moverParaSul() {
		y = planalto.sul(y);
		
	}

	public void moverParaNorte() {
		y = planalto.norte(y);
	}

	public int getEixoX() {
		return x;
	}

	public int getEixoY() {
		return y;
	}
	
}
