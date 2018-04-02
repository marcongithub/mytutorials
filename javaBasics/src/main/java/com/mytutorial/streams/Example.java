package com.mytutorial.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Example {

	public static void main(String... args) throws InterruptedException, ExecutionException {

		// The parallel streams use the default ForkJoinPool which by default has one
		// less threads as you have processors, as returned by
		// Runtime.getRuntime().availableProcessors()

		System.out.println("available processors:" + Runtime.getRuntime().availableProcessors());

		ForkJoinPool forkJoinPool = new ForkJoinPool(2);

		forkJoinPool.submit(() -> test("/home/marco/Arbeitsfläche/test.txt")).get();

	}

	private static List<String> makeWords(String filename) {
		List<String> words = null;
		try {
			words = Arrays.asList(new String(Files.readAllBytes(Paths.get(filename))).split("[^\\p{L}]") // Split into
																											// words;
																											// nonletters
																											// are
																											// delimiters
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}

	private static void test(String filename) {
		List<String> words = makeWords(filename);
		words.parallelStream().forEach(s -> {
			if (s.length() > 0)
				System.out.println(Thread.currentThread().getName() + ": " + s);
		});
	}

}
