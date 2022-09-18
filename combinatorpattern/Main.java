package com.pkj.combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CustomerValidatorServiceImpl validatorService = new CustomerValidatorServiceImpl();
        Customer customer = new Customer(
                "Pankaj Kumar",
                "pkjkumar@iitk.ac.in",
                "919453994875",
                LocalDate.of(1997, 06, 13)
        );
        System.out.println(validatorService.isValid(customer));
        // we can store customer in DB
    }
}
