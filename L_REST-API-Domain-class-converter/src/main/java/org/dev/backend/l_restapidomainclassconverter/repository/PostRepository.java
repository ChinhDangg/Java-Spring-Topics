package org.dev.backend.l_restapidomainclassconverter.repository;

import org.dev.backend.l_restapidomainclassconverter.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
