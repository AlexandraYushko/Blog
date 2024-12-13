package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;

public class ArticlesStarter {
    public static void main(String[] args) {
        ArticlesDAO articlesDAO = new ArticlesDAO();
        ArticlesService articlesService = new ArticlesService(articlesDAO);

        Articles articles = new Articles();
        articles.setTitle("Article");
        articles.setContent("Content");
        articles.setCategoryId(1);
        articles.setAuthorId(2);
        articlesService.createArticle(articles);

        articles.setTitle("New title");
        articles.setContent("New content");
        articlesService.updateArticle(articles);

        int articleId = articles.getId();
        Articles newArticle = articlesService.getArticleById(articleId);
        System.out.println("Ответ " + newArticle);

        int delArticle = 1;
        articlesService.deleteArticle(delArticle);
    }
}
