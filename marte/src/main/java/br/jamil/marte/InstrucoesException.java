package br.jamil.marte;

public class InstrucoesException extends Exception {

	private static final long serialVersionUID = -451839616587755095L;

	public InstrucoesException() {
		super();
	}

	public InstrucoesException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InstrucoesException(String message, Throwable cause) {
		super(message, cause);
	}

	public InstrucoesException(String message) {
		super(message);
	}

	public InstrucoesException(Throwable cause) {
		super(cause);
	}

}
