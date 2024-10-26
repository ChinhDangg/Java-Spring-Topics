package org.dev.database.l_restapitodoservice.repository;

import org.dev.database.l_restapitodoservice.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
