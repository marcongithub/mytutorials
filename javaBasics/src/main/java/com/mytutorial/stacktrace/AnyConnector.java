package com.mytutorial.stacktrace;

public class AnyConnector {

	public void callConnector() throws ConnectorException {
		System.out.println("I am C.");

		try {
			doConnectorCall();
		} catch (Throwable e) {
			throw new ConnectorException("test!",e);
		}

	}

	@SuppressWarnings("null")
	private void doConnectorCall() {
		String a = "";
		if (true) {
			a = null;
		}
		a.lastIndexOf("a");
	}

}
