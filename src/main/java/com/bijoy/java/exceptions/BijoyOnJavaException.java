package com.bijoy.java.exceptions;

/**
 * Java Engineering: REST API exception class.
 * 
 * @author Bijoy Baral
 * @since Monday, August 24, 2020 10:00 am
 *
 */
public class BijoyOnJavaException extends Exception {

	private static final long serialVersionUID = 1L;

	public BijoyOnJavaException(final String exceptionMessage) {
		super(exceptionMessage);
	}

}
