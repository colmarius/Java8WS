package mf.java8ws.talk.example01;

import java.util.*;
import java.util.function.Consumer;

public class InternalIteration {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Java 7
        for (int n : numbers) {
            System.out.println(n);
        }

        // Java 7
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        });

        // Java 8
        numbers.forEach(System.out::println);
    }
}
