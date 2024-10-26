package org.dev.database.listcrudrepository.repository;

import org.dev.database.listcrudrepository.model.Event;
import org.springframework.data.repository.ListCrudRepository;

public interface EventRepository extends ListCrudRepository<Event, Long> {
}
