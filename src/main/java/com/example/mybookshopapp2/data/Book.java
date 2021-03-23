package com.example.mybookshopapp2.data;

public class Book {
    private Integer id;
    private String author;
    private String title;
    private String priceOld;
    private String price;

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPriceOld() {
        return priceOld;
    }

    public Book setPriceOld(String priceOld) {
        this.priceOld = priceOld;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Book setPrice(String price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", priceOld='" + priceOld + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
