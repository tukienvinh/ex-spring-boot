package com.example.exspringboot.service;

import com.example.exspringboot.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> retrieveEmployees();

    public Optional<Employee> getEmployee(Long employeeId);

    public Employee saveEmployee(Employee employeeId);

    public void deleteEmployee(Long employeeId);

    public void updateEmployee(Employee employee);
}
