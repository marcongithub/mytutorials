package com.mytutorial.stacktrace;

public class ClassC {
    
    public void printC(){
        System.out.println("I am C.");
        if(true)
            throw new CsRuntimeException("test!");
    }

}
