package com.example.mybookshopapp2.utils.serialization;

import com.example.mybookshopapp2.model.Author;
import com.example.mybookshopapp2.model.Book;
import com.example.mybookshopapp2.model.Genre;
import com.example.mybookshopapp2.model.Tag;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
        jgen.writeStringField("price", String.valueOf(book.getPrice()));
        jgen.writeEndObject();
    }
}
