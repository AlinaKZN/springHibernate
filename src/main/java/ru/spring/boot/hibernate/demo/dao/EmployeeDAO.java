package ru.spring.boot.hibernate.demo.dao;

import ru.spring.boot.hibernate.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployees();

    Employee get(int id);

    void save(Employee employee);

    void delete(int id);
}
