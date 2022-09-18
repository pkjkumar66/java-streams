package com.pkj.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class flatMap {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .map(e -> func1(e))
                .flatMap(e -> Stream.of(func2(e)))
                .forEach(System.out::println);

        System.out.println("use-case of flatMap");
        // map:: one-to-one  Stream<T> ===> Stream<Y>
        // map:: one-to-many Stream<T> ===> Stream<List<Y>>
        // flatMap:: one-to-many Stream<T> ===> Stream<Y>   ???
    }

    private static Object[] func2(int number) {
        return new Object[]{number - 1, number - 2};
    }

    private static int func1(int number) {
        return number * 2;
    }
}
