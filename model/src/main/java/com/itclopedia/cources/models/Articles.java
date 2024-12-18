package com.itclopedia.cources.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "articles")
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "author_id")
    private int authorId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "premium")
    private boolean premium;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp publicationTime;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
