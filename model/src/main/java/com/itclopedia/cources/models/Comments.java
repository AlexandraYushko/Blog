package com.itclopedia.cources.models;


public class Comments {
    private int id;
    private int authorId;
    private int articleId;
    private String text;

    public Comments(int id, int author_id, int article_id, String text) {
        this.id = id;
        this.authorId = author_id;
        this.articleId = article_id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }
}
