package ru.spring.boot.hibernate.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.boot.hibernate.demo.entity.Employee;
import ru.spring.boot.hibernate.demo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/find")
    public List<Employee> findEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/find/{id}")
    public Employee findEmployee(@PathVariable int id){
        return employeeService.get(id);
    }

    @GetMapping("/save/{id}")
    public void save(@PathVariable int id){
        Employee employee = findEmployee(id);
        employee.setName("John");
        employeeService.save(employee);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }
}
