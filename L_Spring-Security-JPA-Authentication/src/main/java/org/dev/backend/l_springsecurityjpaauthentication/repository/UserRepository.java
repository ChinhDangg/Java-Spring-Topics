package org.dev.backend.l_springsecurityjpaauthentication.repository;

import org.dev.backend.l_springsecurityjpaauthentication.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
