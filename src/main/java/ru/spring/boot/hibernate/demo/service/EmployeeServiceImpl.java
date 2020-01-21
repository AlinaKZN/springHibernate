package ru.spring.boot.hibernate.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.boot.hibernate.demo.dao.EmployeeDAO;
import ru.spring.boot.hibernate.demo.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    @Transactional
    public Employee get(int id) {
        return employeeDAO.get(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);

    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.delete(id);

    }
}
