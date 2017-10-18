package com.mytutorial.stacktrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ClassA {
    
    ClassB b;
    
    private static final Logger LOG = LoggerFactory.getLogger(ClassA.class);
    
    
    public ClassA() {
        this.b=new ClassB();
    }

    public void printA(){
        System.out.println("I am A.");
        try {
            b.printB();
        } catch (RuntimeException e) {
            throw new AsRuntimeException(e);
        }
    }
    
    public static void main(String []args){
        ClassA a = new ClassA();
        try {
            a.printA();
        } catch (Exception e) {
            LOG.error("",e);
        }
    }

}
