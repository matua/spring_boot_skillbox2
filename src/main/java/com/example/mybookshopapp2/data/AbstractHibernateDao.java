package com.example.mybookshopapp2.data;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public abstract class AbstractHibernateDao<T> {

    @Autowired
    EntityManagerFactory entityManagerFactory;
    private Class<T> clazz;

    public AbstractHibernateDao<T> setClazz(Class<T> clazz) {
        this.clazz = clazz;
        return this;
    }

    public T findOne(Long id) {
        return getSession().find(clazz, id);
    }

    public Session getSession() {
        return entityManagerFactory.createEntityManager().unwrap(Session.class);
    }
}