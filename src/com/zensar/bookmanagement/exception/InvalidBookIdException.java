package com.zensar.bookmanagement.exception;

public class InvalidBookIdException extends Exception {

	public InvalidBookIdException() {
	}

	public InvalidBookIdException(String message) {
		super(message);
	}

	public InvalidBookIdException(Throwable cause) {
		super(cause);
	}

	public InvalidBookIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidBookIdException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
