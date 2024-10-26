package org.dev.database.l_graphqlspringbootintro;

import org.dev.database.l_graphqlspringbootintro.model.Book;
import org.dev.database.l_graphqlspringbootintro.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //@SchemaMapping(typeName = "Query", value = "allBooks")
    @QueryMapping
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book findOne(@Argument Integer id) {
        return bookRepository.findOne(id);
    }

    @QueryMapping
    public List<Book> allBookPaged(@Argument int page, @Argument int size) {
        // should use pageAndSortingRepository to query for page instead, but for simplicity this will do it here
        return bookRepository.findPage(page, size);
    }


}
