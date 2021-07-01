package com.example.exspringboot.exception;

public class EmployeeNameException extends RuntimeException {
    public EmployeeNameException(String name) {super("Name already taken: " + name);}
}
