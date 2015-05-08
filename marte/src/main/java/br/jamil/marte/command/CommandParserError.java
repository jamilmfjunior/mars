package br.jamil.marte.command;

public class CommandParserError extends Exception {

	private static final long serialVersionUID = 1927141332809350734L;

	public CommandParserError() {
		super();
	}

	public CommandParserError(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommandParserError(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandParserError(String message) {
		super(message);
	}

	public CommandParserError(Throwable cause) {
		super(cause);
	}
	
	

}
