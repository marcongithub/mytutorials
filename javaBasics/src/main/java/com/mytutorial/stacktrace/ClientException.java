package com.mytutorial.stacktrace;

public class ClientException extends Exception{

	public ClientException(Throwable ex) {
		super(ex);
	}

}
