package br.jamil.marte;

public class Sonda {

	private Bulsola bulsola;
	private Planalto planalto;
	private int x;
	private int y;
	
	public Sonda(int x, int y, Bulsola bulsola) {
		this.bulsola = bulsola;
		this.x = x;
		this.y = y;
	}

	public Planalto getPlanalto() {
		return planalto;
	}

	public void setPlanalto(Planalto planalto) {
		this.planalto = planalto;
	}

	public void virarADireita() {
		bulsola.virouParaDireita();
	}
	
	public void virarAEsquerda() {
		bulsola.virouParaEsquerda();
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
