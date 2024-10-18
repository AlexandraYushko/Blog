package com.itclopedia.cources.models;

import java.sql.Timestamp;


public class Articles {
    private int id;
    private String title;
    private String content;
    private int authorId;
    private int categoryId;
    private boolean premium;
    private Timestamp publicationTime;

    public Articles(int id, String title, String content, int authorId, int categoryId, boolean premium, Timestamp publicationTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.premium = premium;
        this.publicationTime = publicationTime;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public boolean isPremium() {
        return premium;
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
