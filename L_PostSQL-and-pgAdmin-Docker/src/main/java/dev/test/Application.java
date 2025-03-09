package dev.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EventRepository eventRepository) {
        return _ -> {
            if (eventRepository.count() == 0) {
                var event = new Event(
                        1,
                        "SpringOne",
                        "Some description",
                        LocalDate.of(2020, 1, 1),
                        LocalDate.of(2020, 1, 1),
                        "Las Vegas",
                        "https://example.com"
                );
                eventRepository.save(event);
            }
        };
    }
}
