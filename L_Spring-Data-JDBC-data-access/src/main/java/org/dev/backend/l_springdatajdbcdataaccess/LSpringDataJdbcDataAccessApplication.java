package org.dev.backend.l_springdatajdbcdataaccess;

import org.dev.backend.l_springdatajdbcdataaccess.model.Author;
import org.dev.backend.l_springdatajdbcdataaccess.model.Comment;
import org.dev.backend.l_springdatajdbcdataaccess.model.Post;
import org.dev.backend.l_springdatajdbcdataaccess.repository.AuthorRepository;
import org.dev.backend.l_springdatajdbcdataaccess.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class LSpringDataJdbcDataAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(LSpringDataJdbcDataAccessApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository postRepository, AuthorRepository authorRepository) {
        return args -> {
            int authorId = authorRepository.save(new Author(null, "First Name", "Last Name", "email@email.com", "username")).id();
            AggregateReference<Author, Integer> author = AggregateReference.to(authorId);

            Post post = new Post("Some title", "Some content", author);
            post.addComment(new Comment("Name", "Some content of the comment"));
            postRepository.save(post);
        };
    }
}
