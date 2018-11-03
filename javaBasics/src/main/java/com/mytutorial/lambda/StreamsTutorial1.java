package com.mytutorial.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTutorial1 {

    static int counter = 0;

    private static void anyMatch() {
        boolean anyMatch = Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
    }

    public static void main(String[] args) {
        chained();
//        streamOf();
//        lazy();
    }

    private static void chained() {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1", "d1", "d2", "e1", "e2");
        Collections.sort(myList);

        Stream<String> stream = myList.stream();


        for(int i=0;i<3;i++)
        stream
                .filter(s -> {
                    System.out.println("in filter:" + s);
                    sleep();
                    return s.startsWith("c");
                })
                .map(s -> {
                    System.out.println("in map: " + s);
                    return s.toUpperCase();
                })
                .sorted()
                .forEach(System.out::println);
    }

    private static void sleep() {
        counter++;
        try {
            if (counter % 2 == 0) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        }
    }

    private static void streamOf() {
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void lazy() {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                });
    }
}
