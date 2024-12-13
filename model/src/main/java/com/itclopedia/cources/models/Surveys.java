package com.itclopedia.cources.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "serveys")
public class Surveys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "question")
    private String question;

    @Column(name = "des")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp publicationDate;

    public int getId() {
        return id;
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
