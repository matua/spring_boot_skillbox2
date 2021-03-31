package com.example.mybookshopapp2.data;

import org.springframework.stereotype.Repository;

@Repository
public class TestEntityDao extends AbstractHibernateDao<TestEntity>{
    public TestEntityDao(){
        super();
        setClazz(TestEntity.class);
    }
}
