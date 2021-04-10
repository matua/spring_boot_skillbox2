package com.example.mybookshopapp2.data;

public class SearchWordDto {
    private String example;

    public SearchWordDto(String example) {
        this.example = example;
    }

    public SearchWordDto() {
    }

    public String getExample() {
        return example;
    }

    public SearchWordDto setExample(String example) {
        this.example = example;
        return this;
    }
}
