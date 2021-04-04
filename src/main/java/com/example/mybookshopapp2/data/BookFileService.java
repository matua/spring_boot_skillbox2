package com.example.mybookshopapp2.data;

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
