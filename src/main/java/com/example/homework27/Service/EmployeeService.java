package com.example.homework27.Service;

import com.example.homework27.Employee;
import com.example.homework27.Exceptions.EmployeeAlreadyAddedException;
import com.example.homework27.Exceptions.EmployeeNotFoundException;
import com.example.homework27.Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String,Employee> employees = new HashMap<>();


    public EmployeeService() {
        employees.put("one",new Employee("Ivan","Ivanov"));
        employees.put("two",new Employee("Petr","Petrov"));
        employees.put("three",new Employee("Ian","Ianov"));

    }


    public void addEmployee(Employee employee)
            throws EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException {
        if (employees.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put("",employee);
        }
        if (employees.size() > 4) {
            throw new EmployeeStorageIsFullException();
        }
    }

    public void employeeRemove(Employee employee) throws EmployeeNotFoundException {
        if (!employees.containsKey(employee)) {
            throw new EmployeeNotFoundException();
        } else {
            employees.remove(employee);
        }
    }

    public Employee employeeFind(Employee employee) throws EmployeeNotFoundException {
        if (!employees.containsKey(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Map<String,Employee> getEmployees() {
        return employees;
    }


}
