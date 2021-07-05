package com.example.mybookshopapp2.config;

import com.example.mybookshopapp2.model.TestEntity;
import com.example.mybookshopapp2.respository.BookRepository;
import com.example.mybookshopapp2.respository.TestEntityCrudRepository;
import org.springframework.boot.CommandLineRunner;

import java.util.Objects;
import java.util.logging.Logger;


public class CommandLineRunnerImpl implements CommandLineRunner {

    TestEntityCrudRepository testEntityCrudRepository;
    BookRepository bookRepository;

    public CommandLineRunnerImpl(TestEntityCrudRepository testEntityCrudRepository, BookRepository bookRepository) {
        this.testEntityCrudRepository = testEntityCrudRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 5; i++) {
            createTestEntity(new TestEntity());
        }

        TestEntity readTestEntity = readTestEntityById(3L);

        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("read " + readTestEntity);

        TestEntity updatedTestEntity = updateTestEntityById(5L);
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update " + updatedTestEntity);

        deleteTestEntity(4L);

        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.findBookByAuthorsFirstNameContainingIgnoreCase("Jonathan").toString());
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.customFindAllBooks().toString());
    }

    private void deleteTestEntity(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).orElse(null);
        assert testEntity != null;
        testEntityCrudRepository.delete(testEntity);
    }

    private TestEntity updateTestEntityById(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).orElse(null);
        Objects.requireNonNull(testEntity).setData("NEW DATA");
        testEntityCrudRepository.save(testEntity);
        return testEntity;
    }

    private TestEntity readTestEntityById(Long id) {
        return testEntityCrudRepository.findById(id).orElse(null);
    }

    private void createTestEntity(TestEntity entity) {
        entity.setData(entity.getClass().getSimpleName() + entity.hashCode());
        testEntityCrudRepository.save(entity);
    }
}