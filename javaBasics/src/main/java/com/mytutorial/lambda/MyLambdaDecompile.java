package com.mytutorial.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class MyLambdaDecompile {
	
	public static void main(String[]a) {
		
		Function<Integer,String> functionAnonymous = new Function<Integer, String>() {
			@Override
			public String apply(Integer t) {
				return t.toString();
			}
		}; 
		int b =0;
		Function<Integer,String> functionAnonymousLambda = (t)->{return t.toString();};
		
		List<String> list = Arrays.asList("Hallo ","du ", "Sack ");
		BinaryOperator<String> accumulator= new BinaryOperator<String>() {
			
			@Override
			public String apply(String t, String u) {
				// TODO Auto-generated method stub
				return t+u;
			}
		};
		String concat ="";
		list.stream().reduce(concat,accumulator);
		System.out.println(concat);
		
	}
	
	
	public String regularMethod(StringBuffer myStringBuffer) {
		System.out.println("asdfasdf");
		return myStringBuffer.toString();
	}

}
