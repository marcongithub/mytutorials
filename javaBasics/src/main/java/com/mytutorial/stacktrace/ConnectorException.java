package com.mytutorial.stacktrace;

public class ConnectorException extends Exception {

	public ConnectorException(String msg) {
		super(msg);
	}

	public ConnectorException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
