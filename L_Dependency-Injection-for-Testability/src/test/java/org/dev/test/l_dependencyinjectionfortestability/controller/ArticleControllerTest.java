package org.dev.test.l_dependencyinjectionfortestability.controller;

import org.dev.test.l_dependencyinjectionfortestability.model.Article;
import org.dev.test.l_dependencyinjectionfortestability.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    ArticleController articleController;

    @MockBean
    ArticleRepository articleRepository;

    List<Article> articles;

    @BeforeEach
    void setUp() {
        articleController = new ArticleController(articleRepository);
        articles = List.of(
                new Article(1, "Title 1", "Content 1", null),
                new Article(2, "Title 2", "Content 2", null)
        );
    }

    @Test
    void shouldReturnAllArticles() {
        Mockito.when(articleRepository.findAll()).thenReturn(articles);
        assertEquals(2, articleController.getAllArticles().spliterator().getExactSizeIfKnown());
    }

    @Test
    void shouldReturnArticleWithValidId() {
        Mockito.when(articleRepository.findById(1)).thenReturn(articles.get(0));
        Article article = articleController.getArticleById(1);
        assertNotNull(article);
    }
}