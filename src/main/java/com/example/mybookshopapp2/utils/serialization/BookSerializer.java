package com.example.mybookshopapp2.utils.serialization;

import com.example.mybookshopapp2.model.Book;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
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
//        jgen.writeObject(book.getAuthors());
        jgen.writeEndObject();
    }
}
