package com.dotin.leavesystem.dao;

import com.dotin.leavesystem.models.Email;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmailDAOHibernateImpl implements EmailDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public EmailDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Email> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Email> theQuery =
                currentSession.createQuery("select c from Email c", Email.class);
        return theQuery.getResultList();
    }

    @Override
    public Email findById(int Id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Email.class, Id);
    }

    @Override
    public void save(Email email) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(email);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery2 = currentSession.createQuery(
                "delete  from Email  where id=:emailId");

        theQuery2.setParameter("emailId", id);
        theQuery2.executeUpdate();
    }
}
