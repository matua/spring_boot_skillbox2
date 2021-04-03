package com.example.mybookshopapp2.data;

import javax.persistence.*;

@Entity
@Table
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sortIndex;
    private String question;
    private String answer;

    public Integer getId() {
        return id;
    }

    public Faq setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public Faq setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Faq setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Faq setAnswer(String answer) {
        this.answer = answer;
        return this;
    }
}
