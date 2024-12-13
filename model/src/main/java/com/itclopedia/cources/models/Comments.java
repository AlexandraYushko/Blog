package com.itclopedia.cources.models;


import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_id")
    private int authorId;

    @Column(name = "article_id")
    private int articleId;

    @Column(name = "text")
    private String text;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setText(String text) {
        this.text = text;
    }
}
