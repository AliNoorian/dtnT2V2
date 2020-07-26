package com.dotin.leavesystem.dao;

import com.dotin.leavesystem.models.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeServie {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> theQuery =
                currentSession.createQuery("select c from Employee c", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int Id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Employee.class, Id);
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery2 = currentSession.createQuery(
                "delete from Employee where id=:employeeId");

        theQuery2.setParameter("employeeId", id);
        theQuery2.executeUpdate();
    }
}
