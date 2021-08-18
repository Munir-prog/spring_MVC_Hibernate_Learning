package com.mprog.spring.dao;

import com.mprog.spring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        session.saveOrUpdate(e);
//        if (e.getId() == 0) {
//            session.save(e);
//        } else {
//            session.update(e);
//        }
    }

    @Override
    public Employee findByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
