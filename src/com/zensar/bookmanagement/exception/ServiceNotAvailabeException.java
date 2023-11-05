package com.zensar.bookmanagement.exception;

public class ServiceNotAvailabeException extends Exception {

	public ServiceNotAvailabeException() {
	}

	public ServiceNotAvailabeException(String message) {
		super(message);
	}

	public ServiceNotAvailabeException(Throwable cause) {
		super(cause);
	}

	public ServiceNotAvailabeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceNotAvailabeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
