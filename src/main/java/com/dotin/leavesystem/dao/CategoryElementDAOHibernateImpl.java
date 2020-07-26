package com.dotin.leavesystem.dao;

import com.dotin.leavesystem.models.CategoryElement;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryElementDAOHibernateImpl implements CategoryElementDAO {


    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public CategoryElementDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<CategoryElement> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<CategoryElement> theQuery =
                currentSession.createQuery("select c from CategoryElement c", CategoryElement.class);
        return theQuery.getResultList();
    }

    @Override
    public CategoryElement findById(int Id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(CategoryElement.class, Id);
    }

    @Override
    public void save(CategoryElement categoryElement) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(categoryElement);
    }

    @Override
    public void deleteById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery2 = currentSession.createQuery(
                "delete  from CategoryElement  where id=:categoryElementId");

        theQuery2.setParameter("categoryElementId", id);
        theQuery2.executeUpdate();


    }

}
