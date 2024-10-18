package com.itclopedia.cources.models;

import java.sql.Timestamp;

public class Serveys {
    private int id;
    private String type;
    private String question;
    private String description;
    private Timestamp publicationDate;

    public String getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
