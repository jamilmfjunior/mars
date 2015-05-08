package br.jamil.marte;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import br.jamil.marte.command.Command;
import br.jamil.marte.command.CommandCreatePlanalto;
import br.jamil.marte.command.CommandCreateSonda;
import br.jamil.marte.command.CommandMoveSonda;
import br.jamil.marte.command.CommandParser;
import br.jamil.marte.command.CommandParserError;

public class Processador {

	private Reader reader;

	private CommandParser commandParser;

	private Planalto planalto;

	private List<Sonda> sondas = new ArrayList<Sonda>();

	private int sondaSelecionada = -1;

	public Processador(String fileName) throws FileNotFoundException {
		reader = new FileReader(fileName);
		commandParser = new CommandParser();
	}

	public Processador(Reader reader, CommandParser commandParser) {
		this.reader = reader;
		this.commandParser = commandParser;
	}

	public void enviarInstrucoes() throws IOException, CommandParserError,
			InstrucoesException {
		BufferedReader instrucoesReader = new BufferedReader(reader);

		String linha = instrucoesReader.readLine();
		while (linha != null) {
			processaCommando(commandParser.parseLine(linha));
			linha = instrucoesReader.readLine();
		}

		instrucoesReader.close();
		imprimeResultados();
	}

	private void imprimeResultados() {
		for (Sonda sonda : sondas) {
			System.out.println(sonda.getEixoX() + " " + sonda.getEixoY() + " "
					+ sonda.getPosicao().getDirecao());
		}
	}

	public void processaCommando(Command<?> command) throws InstrucoesException {
		if (command instanceof CommandCreatePlanalto) {
			processaResultado((Planalto) command.run());
		} else if (command instanceof CommandCreateSonda) {
			processaResultado((Sonda) command.run());
		} else if (command instanceof CommandMoveSonda) {
			processaMovimento(command);
		}
	}

	private void processaMovimento(Command<?> command)
			throws InstrucoesException {
		if (this.sondas.size() == 0) {
			throw new InstrucoesException(
					"Comandos de movimento devem ser colocados no arquivo após a criação de pelo menos uma sonda.");
		}
		trocaSonda();
		for (int i = 0; i < command.getQtdParametros(); i++) {
			if ("M".equals(command.getParametro(i))) {
				this.sondas.get(sondaSelecionada).mover();
			} else if ("L".equals(command.getParametro(i))) {
				this.sondas.get(sondaSelecionada).virarAEsquerda();
			} else if ("R".equals(command.getParametro(i))) {
				this.sondas.get(sondaSelecionada).virarADireita();
			}
		}
	}

	private void trocaSonda() {
		sondaSelecionada++;
		if (sondaSelecionada >= sondas.size()) {
			sondaSelecionada = 0;
		}
	}

	private void processaResultado(Sonda sonda) throws InstrucoesException {
		if (planalto == null) {
			throw new InstrucoesException(
					"Erro na orden das instruções do arquivo, planalto deve ser a primeira instrução.");
		}
		sonda.setPlanalto(planalto);
		this.sondas.add(sonda);
	}

	public void processaResultado(Planalto planalto) {
		this.planalto = planalto;
	}

}
