package com.mytutorial.stacktrace;

public class AnyService {
    
    AnyConnector connector;
    
    public AnyService() {
        this.connector= new AnyConnector();
    }

    public void callService() throws ServiceException{
        System.out.println("I am B.");
        try {
			connector.callConnector();
		} catch (ConnectorException e) {
			throw new ServiceException(e);
		}
        
    }

}
