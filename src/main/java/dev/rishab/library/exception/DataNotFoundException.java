package dev.rishab.library.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}

	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String toString() {
		return ("DataNotFoundException Occurred: " + getMessage());
	}

}
