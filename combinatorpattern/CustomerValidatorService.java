package com.pkj.combinatorpattern;

import java.time.LocalDate;

public interface CustomerValidatorService {
    boolean isEmailValid(String email);
    boolean isPhoneNumberValid(String phoneNumber);
    boolean isAdult(LocalDate dob);
    boolean isValid(Customer customer);
}
