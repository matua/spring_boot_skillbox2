package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.Tag;
import com.example.mybookshopapp2.respository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagBySlug(String slug) {
        return tagRepository.findTagBySlug(slug);
    }
}