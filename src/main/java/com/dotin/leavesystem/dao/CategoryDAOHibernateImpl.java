package com.dotin.leavesystem.dao;

import com.dotin.leavesystem.models.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryDAOHibernateImpl implements CategoryService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public CategoryDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Category> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Category> theQuery =
                currentSession.createQuery("select c from Category c", Category.class);
        return theQuery.getResultList();
    }

    @Override
    public Category findById(int Id) {

        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Category.class, Id);

    }

    //Id=0 save/insert else update
    @Override
    public void save(Category category) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(category);

    }

    @Override
    public void deleteById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery2 = currentSession.createQuery(
                "delete  from Category where id=:categoryId");

        theQuery2.setParameter("categoryId", id);
        theQuery2.executeUpdate();

    }

}
