package org.viapivov.loader;

public class LoadInfoException extends RuntimeException {

	public LoadInfoException() {
	}

	public LoadInfoException(String message) {
		super(message);
	}

	public LoadInfoException(Throwable cause) {
		super(cause);
	}

	public LoadInfoException(String message, Throwable cause) {
		super(message, cause);
	}

}
