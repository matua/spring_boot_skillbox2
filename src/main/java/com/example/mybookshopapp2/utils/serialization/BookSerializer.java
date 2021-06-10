package com.example.mybookshopapp2.utils.serialization;

import com.example.mybookshopapp2.model.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class BookSerializer extends StdSerializer<Book> {
    public BookSerializer() {
        this(null);
    }

    public BookSerializer(Class<Book> t) {
        super(t);
    }

    @Override
    public void serialize(Book book, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {


        jgen.writeStartObject();
        jgen.writeNumberField("id", book.getId());
        jgen.writeStringField("title", book.getTitle());
        jgen.writeStringField("pubDate", String.valueOf(book.getPubDate()));
        jgen.writeStringField("isBestseller", String.valueOf(book.getIsBestseller()));
        jgen.writeStringField("slug", book.getSlug());
        jgen.writeStringField("image", book.getImage());
        jgen.writeStringField("rating", String.valueOf(book.getRating()));
        jgen.writeArrayFieldStart("authors");
        for (Author author : book.getAuthors()) {
            jgen.writeString(author.getFirstName() + " " + author.getLastName());
        }
        jgen.writeEndArray();
        jgen.writeStringField("description", book.getDescription());
        jgen.writeArrayFieldStart("genres");
        for (Genre genre : book.getGenres()) {
            jgen.writeString(genre.getName());
        }
        jgen.writeEndArray();
        jgen.writeArrayFieldStart("tags");
        for (Tag tag : book.getTags()) {
            jgen.writeString(tag.getName());
        }
        jgen.writeEndArray();
        jgen.writeArrayFieldStart("users");
        for (User user : book.getUsers()) {
            jgen.writeString(user.getName());
        }
        jgen.writeEndArray();
        jgen.writeArrayFieldStart("bookFileList");
        for (BookFile bookFile : book.getBookFileList()) {
            jgen.writeString(bookFile.getBookFileExtensionString());
        }
        jgen.writeEndArray();
        jgen.writeStringField("discount", String.valueOf(book.getPrice()));
        jgen.writeStringField("price", String.valueOf(book.getPriceOld()));
        jgen.writeStringField("discountPrice", String.valueOf(book.discountPrice()));
        jgen.writeEndObject();
    }
}