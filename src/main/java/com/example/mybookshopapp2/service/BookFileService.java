package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.BookFile;
import com.example.mybookshopapp2.respository.BookFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookFileService {
    private final BookFileRepository bookFileRepository;

    @Autowired
    public BookFileService(BookFileRepository bookFileRepository) {
        this.bookFileRepository = bookFileRepository;
    }

    public List<BookFile> getAllBookFiles() {
        return bookFileRepository.findAll();
    }
}
