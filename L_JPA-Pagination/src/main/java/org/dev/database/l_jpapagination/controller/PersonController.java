package org.dev.database.l_jpapagination.controller;

import org.dev.database.l_jpapagination.model.Person;
import org.dev.database.l_jpapagination.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonRepository personRepository;
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Page<Person> findAll(@RequestParam int page, @RequestParam int size) {
        PageRequest pr = PageRequest.of(page, size); // ?page=0&size=2
        return personRepository.findAll(pr);
    }
}
