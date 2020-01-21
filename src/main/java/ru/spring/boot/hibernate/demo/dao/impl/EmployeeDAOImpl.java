package ru.spring.boot.hibernate.demo.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.boot.hibernate.demo.dao.EmployeeDAO;
import ru.spring.boot.hibernate.demo.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAllEmployees() {
        //get current session
        Session session = entityManager.unwrap(Session.class);

        //generate query
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        //get dt from query
        List<Employee> employees = query.getResultList();

        //return results

        return employees;
    }

    @Override
    public Employee get(int id) {
        //get current session
        Session session = entityManager.unwrap(Session.class);

        //get employee from query by id
        Employee employee = session.get(Employee.class, id);

        //return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        //get current session
        Session session = entityManager.unwrap(Session.class);

        //save employee
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        //get current session
        Session session = entityManager.unwrap(Session.class);

        //get employee by id

        Employee employee = session.get(Employee.class, id);

        //delete employee by id
        session.delete(employee);
    }
}
