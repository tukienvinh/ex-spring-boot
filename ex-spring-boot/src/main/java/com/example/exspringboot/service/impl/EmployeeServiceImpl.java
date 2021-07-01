package com.example.exspringboot.service.impl;

import com.example.exspringboot.entity.Employee;
import com.example.exspringboot.exception.EmployeeException;
import com.example.exspringboot.repository.EmployeeRepository;
import com.example.exspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Optional<Employee> getEmployee(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    };

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployee(Employee newEmployee, Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setGender(newEmployee.getGender());
                    employee.setJob(newEmployee.getJob());
                    return saveEmployee(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return saveEmployee(newEmployee);
                });
    }
}
