package org.dev.database.l_jpapagination.data;

import com.github.javafaker.Faker;
import org.dev.database.l_jpapagination.model.Address;
import org.dev.database.l_jpapagination.model.Person;
import org.dev.database.l_jpapagination.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
    private final PersonRepository personRepository;
    private final Faker faker;

    public SampleDataLoader(PersonRepository personRepository, Faker faker) {
        this.personRepository = personRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading data...");
        List<Person> personList = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()
                        )
                ))
                .toList();
        personRepository.saveAll(personList);
    }
}
