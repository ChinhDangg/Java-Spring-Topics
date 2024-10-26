package org.dev.database.l_graphqlspringbootintro.repository;

import jakarta.annotation.PostConstruct;
import org.dev.database.l_graphqlspringbootintro.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public List<Author> findAll() {
        return authors;
    }

    public Author findById(Integer id) {
        return authors.stream()
                .filter(author -> Objects.equals(author.id(), id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author findByName(String name) {
        return authors.stream()
                .filter(author -> author.fullName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }


    @PostConstruct
    private void init() {
        authors.add(new Author(1, "Josh", "Long"));
        authors.add(new Author(2, "Mark", "Heckler"));
        authors.add(new Author(3, "Greg", "Turnquist"));
    }


}
