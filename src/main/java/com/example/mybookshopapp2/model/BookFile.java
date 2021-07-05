package com.example.mybookshopapp2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class BookFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hash;
    private Integer typeId;
    private String path;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    //@JoinColumn - соединительная колонка в ЭТОМ классе

    //name = "book_id" - название колонки, которую мы хотим назначить
    //этому полю в данном классе для таблицы этого класса

    //referencedColumnName = "id" - название колонки в связанном классе,
    //которое относится к колонке в данном классе
    private Book book;

    public String getBookFileExtensionString() {
        return BookFileType.getExtensionStringByTypeId(typeId);
    }
}
