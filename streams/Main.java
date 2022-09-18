package com.pkj.streams;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();
        // Imperative approach: U define every single step what r u trying to achieve
        List<Person> female = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender() == Gender.FEMALE) {
                female.add(person);
            }
        }
        System.out.println("Imperative approach:");
//        female.forEach(System.out::println);

        // advance: find the oldest female in the list
        int age = 0;
        int index = 0;
        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                if (person.getAge() > age) {
                    age = person.getAge();
                    index = people.indexOf(person);
                }
            }
        }
        System.out.println(people.get(index).getName());


        // Declarative approach

        // 1.Filter
        List<Person> femaleList = people.stream()
                .filter(Person -> Person.getGender() == Gender.FEMALE)
                .collect(Collectors.toList());
        System.out.println("\nDeclarative approach:");
//        femaleList.forEach(System.out::println);

        // 2.Sort
        List<Person> sortedList = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getGender)
                        .reversed())
                .collect(Collectors.toList());
//        sortedList.forEach(System.out::println);

        //    3. All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);
//        System.out.println(allMatch);

        //    4. Any match (atleast one match)
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);
//        System.out.println(anyMatch);

        //    5. None match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("James Bond"));
//        System.out.println(noneMatch);

        //    6. Max
        Optional<Person> max = people.stream()
                .max(Comparator.comparing(Person::getAge));
//        System.out.println(max);

        //    7. Min
        people.stream()
                .min(Comparator.comparing(Person::getAge));
//                .ifPresent(System.out::println);

        //    8. Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach(((gender, people1) -> {
//            System.out.println(gender);
//            people1.forEach(System.out::println);
//            System.out.println();
        }));

        // Advance use of streams
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(person -> person.getName())
                .ifPresent(System.out::println);
    }


    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
