package br.com.plataformalancamento.exception;

public class EmptyResultDataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyResultDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyResultDataAccessException(String message) {
		super(message);
	}

}
