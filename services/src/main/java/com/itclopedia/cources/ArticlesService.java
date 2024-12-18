package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {
    private final ArticlesDAO articlesDAO;

    @Autowired
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

    public Articles getArticleById(int articleId) {
        return articlesDAO.getArticleById(articleId);
    }

    public List<Articles> getAllArticle() {
        return articlesDAO.getAllArticles();
    }
}
