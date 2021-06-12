package com.example.mybookshopapp2.utils.serialization;

import com.example.mybookshopapp2.model.Author;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Set;

public class BookAuthorsSerializer extends JsonSerializer<Set<Author>> {

    @Override
    public void serialize(Set<Author> authors, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeArrayFieldStart("authors");
        for (Author author : authors) {
            gen.writeString(author.getFirstName() + " " + author.getLastName());
        }
        gen.writeEndArray();
    }
}
