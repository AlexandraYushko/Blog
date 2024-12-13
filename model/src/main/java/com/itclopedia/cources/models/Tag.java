package com.itclopedia.cources.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "publicationtime")
    private Timestamp publicationDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setId(int id) {
        this.id = id;
    }
}
