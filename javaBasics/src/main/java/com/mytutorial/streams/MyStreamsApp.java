package com.mytutorial.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class MyStreamsApp {

	public static void main(String[] args) {

		List<String> words = Arrays.asList("parole", "palabras");

		words.stream().forEach(s -> {
			if (s.length() > 0) {
//				System.out.println("");
			}
		});

	List<Integer> intList = words.stream().map(new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return t.length();
			}
		}).collect(Collectors.toList());
	
	intList = words.stream().map(String::length).collect(Collectors.toList());
	

//		words.stream().filter(word -> word.startsWith("p")).map(word-> word.toUpperCase()).forEach(System.out::println);
	
	List<Double> doubleList = Arrays.asList(6000d,6500d,9000d);
	
	doubleList.stream().map(new Function<Double, Double>() {

		@Override
		public Double apply(Double t) {
			// TODO Auto-generated method stub
			return new NettoRechner().nettoEk(t);
		}
	});
	
	doubleList.stream().map(t->new NettoRechner().nettoEk(t));
	NettoRechner nettoRechner=new NettoRechner();
	
	doubleList.stream().map(nettoRechner::nettoEk);
	doubleList.stream().map((new NettoRechner())::nettoEk);
	
	
	}

	private static void test() {
		int factor = 1000; // 1
		IntUnaryOperator times1000 = (int x) -> {
			return x * factor;
		}; // 2
		Arrays.stream(new int[] { 1, 2, 3, 4, 5 }).map(times1000).forEach(System.out::println); // 3
	}

	static class NettoRechner {
		private static double EKST = 35.0d;

		public double nettoEk(double bruttoEk) {
			return bruttoEk - (bruttoEk / 100) * EKST;
		}
	}
}
