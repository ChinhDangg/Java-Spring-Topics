package org.dev.backend.l_springdatajdbcdataaccess.controller;

import lombok.Getter;
import org.dev.backend.l_springdatajdbcdataaccess.model.Author;
import org.dev.backend.l_springdatajdbcdataaccess.model.Post;
import org.dev.backend.l_springdatajdbcdataaccess.model.dto.PostDetails;
import org.dev.backend.l_springdatajdbcdataaccess.repository.AuthorRepository;
import org.dev.backend.l_springdatajdbcdataaccess.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostController(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post findPostById(@PathVariable("id") Post post) {
        return post;
    }

    @GetMapping("/{id}/details")
    public PostDetails findPostDetailsByPostId(@PathVariable("id") Post post) {
        Author author = (post.getAuthor().getId() == null) ? null : authorRepository.findById(post.getAuthor().getId()).orElse(null);
        return new PostDetails(post, author);
    }
}
