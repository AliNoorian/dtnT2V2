package com.dotin.leavesystem.dao;

import com.dotin.leavesystem.models.Leave;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LeaveDAOHibernateImpl implements LeaveDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public LeaveDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Leave> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Leave> theQuery =
                currentSession.createQuery("select c from Leave c", Leave.class);
        return theQuery.getResultList();
    }

    @Override
    public Leave findById(int Id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Leave.class, Id);
    }

    @Override
    public void save(Leave leave) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(leave);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery2 = currentSession.createQuery(
                "delete  from Leave  where id=:leaveId");

        theQuery2.setParameter("leaveId", id);
        theQuery2.executeUpdate();

    }
}
