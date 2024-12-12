package org.dev.backend.l_springsecurityjpaauthentication.repository;

import org.dev.backend.l_springsecurityjpaauthentication.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
