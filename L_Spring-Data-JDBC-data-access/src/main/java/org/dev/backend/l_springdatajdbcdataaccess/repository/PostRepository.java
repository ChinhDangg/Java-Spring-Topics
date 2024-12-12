package org.dev.backend.l_springdatajdbcdataaccess.repository;

import org.dev.backend.l_springdatajdbcdataaccess.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
