package br.jamil.marte.bulsola;

public class PontoCardeal {
	
	private PontoCardeal direita;
	private PontoCardeal esquerda;
	private Direcao value;
	
	public PontoCardeal(Direcao value) {
		this.setValue(value);
	}

	public PontoCardeal getDireita() {
		return direita;
	}

	public void setDireita(PontoCardeal direita) {
		this.direita = direita;
	}

	public PontoCardeal getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(PontoCardeal esquerda) {
		this.esquerda = esquerda;
	}

	public Direcao getValue() {
		return value;
	}

	public void setValue(Direcao value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object pontoCardeal) {
		return this.value == ((PontoCardeal)pontoCardeal).getValue();
	}

}
