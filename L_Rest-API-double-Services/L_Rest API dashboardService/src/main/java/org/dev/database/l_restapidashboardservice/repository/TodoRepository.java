package org.dev.database.l_restapidashboardservice.repository;

import org.dev.database.l_restapidashboardservice.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
