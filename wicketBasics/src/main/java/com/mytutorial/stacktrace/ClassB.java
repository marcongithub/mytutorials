package com.mytutorial.stacktrace;

public class ClassB {
    
    ClassC c;
    
    public ClassB() {
        this.c= new ClassC();
    }

    public void printB(){
        System.out.println("I am B.");
        try {
            c.printC();
        } catch (RuntimeException e) {
            throw new BsRuntimeException(e);
        }
        
    }

}
