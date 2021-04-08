package com.example.mybookshopapp2.respository;

import com.example.mybookshopapp2.model.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityCrudRepository extends CrudRepository<TestEntity, Long> {
}
