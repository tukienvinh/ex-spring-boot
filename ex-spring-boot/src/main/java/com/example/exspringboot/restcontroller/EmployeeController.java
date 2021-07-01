package com.example.exspringboot.restcontroller;

import com.example.exspringboot.entity.Employee;
import com.example.exspringboot.exception.EmployeeException;
import com.example.exspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> findEmployee(@PathVariable Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployee(employeeId);
        if (employee.isPresent() == false) {
            throw new EmployeeException(employeeId);
        }
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public Employee saveEmployee(Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public HashMap<String, String> deleteEmployee(@PathVariable(name="employeeId")Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployee(employeeId);
        if (employee.isPresent() == false) {
            throw new EmployeeException(employeeId);
        }
        employeeService.deleteEmployee(employeeId);
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "Delete successfully!");
        return map;
    }
}
