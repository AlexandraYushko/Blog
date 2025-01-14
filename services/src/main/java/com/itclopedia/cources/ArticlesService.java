package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ArticlesService {
    private final ArticlesRepository articlesRepository;

    @Autowired
    public ArticlesService(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public void createArticle(Articles article) {
        articlesRepository.save(article);
    }

    public void updateArticle(Articles article) {
        articlesRepository.save(article);
    }

    public void deleteArticle(int articleId) {
        articlesRepository.deleteById(articleId);
    }

    public Articles getArticleById(int articleId) {
        return articlesRepository.findById(articleId).orElse(null);
    }

    public List<Articles> getAllArticle() {
        return articlesRepository.findAll();
    }
}
