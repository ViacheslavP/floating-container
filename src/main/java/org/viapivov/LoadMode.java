package org.viapivov;

public enum LoadMode {
	LAZY, EAGER;

	public static class ModeDoesNotExistException extends RuntimeException {

		public ModeDoesNotExistException() {
		}

		public ModeDoesNotExistException(String message) {
			super(message);
		}

		public ModeDoesNotExistException(Throwable cause) {
			super(cause);
		}

		public ModeDoesNotExistException(String message, Throwable cause) {
			super(message, cause);
		}

	}
}
