package org.dev.backend.l_springdatajdbcdataaccess.repository;

import org.dev.backend.l_springdatajdbcdataaccess.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
