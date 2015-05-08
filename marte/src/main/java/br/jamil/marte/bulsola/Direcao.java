package br.jamil.marte.bulsola;

public enum Direcao {
	
	Norte("N"),
	Sul("S"),
	Leste("E"),
	Oeste("W");

	String direcao;

	Direcao(String direcao) {
		this.direcao = direcao;
	}
	
	public static Direcao valueToDirection(String value) {
		for (Direcao valor : Direcao.values()) {
			if (valor.direcao.equals(value)) {
				return valor;
			}
		}
		return null;
	}
	
	public String getDirecao() {
		return this.direcao;
	}
}
