package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;

import java.util.List;

public class ArticlesService {
    private final ArticlesDAO articlesDAO;

    public ArticlesService(ArticlesDAO articlesDAO) {
        this.articlesDAO = new ArticlesDAO();
    }

    public void createArticle(Articles article) {
        articlesDAO.addArticle(article);
    }

    public void updateArticle(Articles article) {
        articlesDAO.updateArticle(article);
    }

    public void deleteArticle(int articleId) {
        articlesDAO.deleteArticle(articleId);
    }

    public Articles getArticleById(int articleId) {
        return articlesDAO.getArticleById(articleId);
    }

    public List<Articles> getAllArticle() {
        return articlesDAO.getAllArticles();
    }
}
