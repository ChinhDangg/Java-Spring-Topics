package org.dev.database.listcrudrepository;

import org.dev.database.listcrudrepository.model.Event;
import org.dev.database.listcrudrepository.repository.EventRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import java.time.LocalDate;

@SpringBootApplication
@EnableJdbcRepositories
public class ListCrudRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListCrudRepositoryApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(EventRepository eventRepository) {
        return args -> eventRepository.save(new Event(
                null,
                "Chicago",
                LocalDate.now(),
                LocalDate.now()
        ));
    }

}
