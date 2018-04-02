package com.mytutorial.stacktrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class AnyClient {
    
    AnyService service;
    
    private static final Logger LOG = LoggerFactory.getLogger(AnyClient.class);
    
    
    public AnyClient() {
        this.service=new AnyService();
    }

    public void anyUseCase() throws ClientException{
        System.out.println("I am A.");
        try {
			service.callService();
		} catch (ServiceException e) {
			throw new ClientException(e);
		}
    }
    
    public static void main(String []args){
        AnyClient client = new AnyClient();
        try {
            client.anyUseCase();
        } catch (Exception e) {
        	Throwable toLog = e.getCause();
        	StackTraceElement stackTrace[]=toLog.getStackTrace();
            LOG.error("Exception caught",e);
        }
    }
    
//    if (rootCause.getStackTrace().length > 0) {
//        StackTraceElement first = rootCause.getStackTrace()[0];
//        int i = 0;
//        while (first.getClassName().equals(ArgChecker.class.getName())) {
//            i++;
//            first = rootCause.getStackTrace()[i];
//            if (i > 10) {
//                break;
//            }
//        }
//
//        sb.append(first.getClassName());
//        sb.append(first.getMethodName());
//    }

}
