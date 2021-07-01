package com.example.exspringboot.exception;

public class EmployeeNameNullException extends RuntimeException {
    public EmployeeNameNullException() {super("Name is null");}
}