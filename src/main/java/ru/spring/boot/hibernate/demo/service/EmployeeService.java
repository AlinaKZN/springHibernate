package ru.spring.boot.hibernate.demo.service;

import ru.spring.boot.hibernate.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee get(int id);

    void save(Employee employee);

    void delete(int id);

}
