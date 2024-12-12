package org.dev.test.l_dependencyinjectionfortestability.repository;

import org.dev.test.l_dependencyinjectionfortestability.model.Article;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ArticleRepository {

    private final List<Article> articles;

    public ArticleRepository() {
        articles = List.of(
                new Article(1, "Title 1", "Content 1", null),
                new Article(2, "Title 2", "Content 2", null),
                new Article(3, "Title 3", "Content 3", null)
        );
    }

    public List<Article> findAll() {
        return articles;
    }

    public Article findById(Integer id) {
        return articles.stream()
                .filter(article -> article.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
