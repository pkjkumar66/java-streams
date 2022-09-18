package com.pkj.optionals;

import java.util.Optional;

public class main {
    public static void main(String[] args) {

        // if var is empty
//        System.out.println("var is empty: ");
        Optional<Object> empty = Optional.empty();
//        System.out.println(empty.isPresent());
//        System.out.println(empty.isEmpty());
//        System.out.println("");

        // if var is not empty
        System.out.println("var is not empty: ");
        Optional<String> optional1 = Optional.of(null);
        System.out.println(optional1.isPresent());
        System.out.println(optional1.isEmpty());

        String orElse = optional1.orElse("world");
        System.out.println(orElse);

        // when u r not sure ur value is null or not then use nullable
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        String world = optional.orElse("world");
        System.out.println(world);

    }
}
