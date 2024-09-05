package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;

import java.util.List;

public class ArticlesService {
    private ArticlesDAO articlesDAO;

    public ArticlesService(ArticlesDAO articlesDAO) {
        this.articlesDAO = articlesDAO;
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

    public List<Articles> getAllArticle() {
        return articlesDAO.getAllArticles();
    }
}
