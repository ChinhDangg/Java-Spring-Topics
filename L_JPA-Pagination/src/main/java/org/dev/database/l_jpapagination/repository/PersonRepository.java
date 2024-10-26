package org.dev.database.l_jpapagination.repository;

import org.dev.database.l_jpapagination.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer>, CrudRepository<Person, Integer> {
}
