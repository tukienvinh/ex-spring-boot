package com.example.exspringboot.exception;

public class EmployeeException extends RuntimeException {
    public EmployeeException(long id) {super("Could not find the employee with id = " + id);}
}
