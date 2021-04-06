package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.Faq;
import com.example.mybookshopapp2.respository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {
    private final FaqRepository faqRepository;

    @Autowired
    public FaqService(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    public List<Faq> getallFaq() {
        return faqRepository.findAll();
    }
}
