package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ArticlesServiceTest {
    private ArticlesService articlesService;
    private ArticlesDAO articlesDAO;

    @BeforeEach
    public void setup() {
        articlesDAO = Mockito.mock(ArticlesDAO.class);
        articlesService = new ArticlesService(articlesDAO);
    }

    @Test
    public void testCreate() {
        Articles article = new Articles();
        article.setAuthorId(2);
        article.setTitle("Title");
        article.setContent("Content");
        doNothing().when(articlesDAO).addArticle(article);
        articlesService.createArticle(article);
        verify(articlesDAO, times(1)).addArticle(article);
    }

    @Test
    public void testUpdate() {
        Articles article = new Articles();
        article.setAuthorId(2);
        article.setCategoryId(3);
        article.setTitle("Title");
        article.setContent("Content");
        article.setPremium(false);
        doNothing().when(articlesDAO).updateArticle(article);
        articlesService.updateArticle(article);
        verify(articlesDAO, times(1)).updateArticle(article);
    }

    @Test
    public void testRead() {
        int id = 2;
        Articles articles = new Articles();
        articles.setTitle("Title");
        when(articlesDAO.getArticleById(id)).thenReturn(articles);
        Articles article = articlesService.getArticleById(id);
        assertEquals("Article", article.getTitle());
    }

    @Test
    public void testDelete() {
        int id = 3;
        doNothing().when(articlesDAO).deleteArticle(id);
        when(articlesDAO.getArticleById(id)).thenReturn(null);
        articlesService.deleteArticle(id);
        verify(articlesDAO, times(1)).deleteArticle(id);
        Articles deletedArticle = articlesService.getArticleById(id);
        assertNull(articlesService.getArticleById(id));
    }
}
