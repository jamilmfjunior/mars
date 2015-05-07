package br.jamil.marte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bulsola {
	
	List<PontoCardeal> pontosCardeais = new ArrayList<PontoCardeal>();
	
	PontoCardeal pontoCardeal;
	
	public Bulsola(Direcao direcao) {
		PontoCardeal norte = new PontoCardeal(Direcao.Norte);
		PontoCardeal sul = new PontoCardeal(Direcao.Sul);
		PontoCardeal leste = new PontoCardeal(Direcao.Leste);
		PontoCardeal oeste = new PontoCardeal(Direcao.Oeste);
		
		norte.setEsquerda(oeste);
		norte.setDireita(leste);
		
		sul.setDireita(oeste);
		sul.setEsquerda(leste);
		
		leste.setDireita(sul);
		leste.setEsquerda(norte);
		
		oeste.setDireita(norte);
		oeste.setEsquerda(sul);
		
		pontosCardeais.addAll(Arrays.asList(norte, sul, leste, oeste));
		
		pontoCardeal = pontosCardeais.get(pontosCardeais.indexOf(new PontoCardeal(direcao)));
	}
	
	public Direcao virarParaDireita() {
		pontoCardeal = pontoCardeal.getDireita();
		return pontoCardeal.getValue();
	}
	
	public Direcao virarParaEsquerda() {
		pontoCardeal = pontoCardeal.getEsquerda();
		return pontoCardeal.getValue();
	}
	
	public Direcao getDirecao() {
		return pontoCardeal.getValue();
	}

}
