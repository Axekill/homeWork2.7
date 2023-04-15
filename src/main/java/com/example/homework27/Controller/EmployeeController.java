package com.example.homework27.Controller;

import com.example.homework27.Employee;
import com.example.homework27.Exceptions.EmployeeAlreadyAddedException;
import com.example.homework27.Exceptions.EmployeeNotFoundException;
import com.example.homework27.Exceptions.EmployeeStorageIsFullException;
import com.example.homework27.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.addEmployee(employee);
            return "Сотрудник добавлен: " + employee;
        } catch (EmployeeStorageIsFullException e) {
            return "Список переполнен";
        } catch (EmployeeAlreadyAddedException e) {
            return "такой сотрудник уже существует: " + employee;
        }

    }


    @GetMapping("/remove")
    public String employeeRemove(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.employeeRemove(employee);
            return "сотрудник удалён: " + employee;
        } catch (EmployeeNotFoundException e) {
            return "данного сотрудника не существует";
        }
    }

    @GetMapping("/find")
    public String employeeFind(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            return "Сотрудник найден: " + employeeService.employeeFind(employee);

        } catch (EmployeeNotFoundException e) {
            return "такого сотрудника не существует";
        }
    }

    @GetMapping("/list")
    public Map<String,Employee> list() {
        return employeeService.getEmployees();

    }


}
