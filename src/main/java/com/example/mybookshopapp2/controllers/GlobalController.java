package com.example.mybookshopapp2.controllers;

import com.example.mybookshopapp2.data.SearchWordDto;
import com.example.mybookshopapp2.model.Book;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalController {

    @ModelAttribute("searchResults")
    public List<Book> searchResults() {
        return new ArrayList<>();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @ModelAttribute("itemsInCart")
    public Integer getItemsInCart(@CookieValue(name = "cartContents", required = false) String cartContents) {
        return getQuantity(cartContents);
    }

    @ModelAttribute("itemsInPostponed")
    public Integer getItemsInPostponed(@CookieValue(name = "postponedContents", required = false) String postponedContents) {
        return getQuantity(postponedContents);
    }

    private Integer getQuantity(String cookies) {
        if (cookies == null || cookies.equals("")) {
            return 0;
        }
        cookies = cookies.endsWith("/") ? cookies.substring(0, cookies.length() - 1) : cookies;
        String[] cookiesArray = cookies.split("/");
        return cookiesArray.length;
    }
}
