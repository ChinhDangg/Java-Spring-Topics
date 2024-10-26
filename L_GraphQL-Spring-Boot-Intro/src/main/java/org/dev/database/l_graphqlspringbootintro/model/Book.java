package org.dev.database.l_graphqlspringbootintro.model;

public record Book(Integer id, String title, Integer pages, Rating rating, Author author) {
}
