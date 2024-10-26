package org.dev.database.l_graphqlspringbootintro.repository;

import jakarta.annotation.PostConstruct;
import org.dev.database.l_graphqlspringbootintro.model.Book;
import org.dev.database.l_graphqlspringbootintro.model.Rating;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository {

    private final AuthorRepository authorRepository;
    private final List<Book> books = new ArrayList<>();

    public BookRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findOne(Integer id) {
        return books.stream()
                .filter(book -> Objects.equals(book.id(), id))
                .findFirst().orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> findPage(int page, int size) {
        int start = (page - 1) * size;
        if (start >= books.size())
            return books;
        return books.subList(start, Math.min(start + size, books.size()));
    }

    @PostConstruct
    private void init() {
        books.add(new Book(1,
                "Reactive Spring",
                484,
                Rating.FIVE_STARS,
                authorRepository.findByName("Josh Long")));
        books.add(new Book(2,
                "Spring Boot Up & Running",
                328,
                Rating.FIVE_STARS,
                authorRepository.findByName("Mark Heckler")));
        books.add(new Book(3,
                "Hacking with Spring Boot 2.3",
                392,
                Rating.FIVE_STARS,
                authorRepository.findByName("Greg Turnquist")));
    }

}
