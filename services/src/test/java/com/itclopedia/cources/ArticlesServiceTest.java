package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ArticlesServiceTest {
    private ArticlesService articlesService;
    private ArticlesRepository articlesRepository;

    @BeforeEach
    public void setup() {
        articlesRepository = Mockito.mock(ArticlesRepository.class);
        articlesService = new ArticlesService(articlesRepository);
    }

    @Test
    public void testCreate() {
        Articles article = new Articles();
        article.setAuthorId(2);
        article.setTitle("Title");
        article.setContent("Content");
        articlesService.createArticle(article);
        verify(articlesRepository, times(1)).save(article);
        assertEquals("Title", article.getTitle());
    }

    @Test
    public void testUpdate() {
        Articles article = new Articles();
        article.setId(1);
        article.setAuthorId(2);
        article.setCategoryId(3);
        article.setTitle("NewTitle");
        article.setContent("Content");
        article.setPremium(false);
        when(articlesRepository.existsById(article.getId())).thenReturn(true);
        articlesService.updateArticle(article);
        verify(articlesRepository, times(1)).save(article);
        assertEquals("NewTitle", article.getTitle());
    }

    @Test
    public void testRead() {
        int id = 2;
        Articles articles = new Articles();
        articles.setTitle("Title");
        when(articlesRepository.findById(id)).thenReturn(Optional.of(articles));
        Articles article = articlesService.getArticleById(id);
        assertEquals("Article", article.getTitle());
    }

    @Test
    public void testDelete() {
        int id = 3;
        when(articlesRepository.existsById(id)).thenReturn(null);
        articlesService.deleteArticle(id);
        verify(articlesRepository, times(1)).deleteById(id);
    }
}
