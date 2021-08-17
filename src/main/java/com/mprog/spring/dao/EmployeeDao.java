package com.mprog.spring.dao;

import com.mprog.spring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDao implements Dao<Employee> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Employee",
                Employee.class).getResultList();
    }

    @Override
    public void save(Employee e) {
        Session session = sessionFactory.getCurrentSession();
        session.save(e);
    }
}
