package org.viapivov.listener;

public class ListenerException extends RuntimeException {

	public ListenerException() {
	}

	public ListenerException(String message) {
		super(message);
	}

	public ListenerException(Throwable cause) {
		super(cause);
	}

	public ListenerException(String message, Throwable cause) {
		super(message, cause);
	}

}
