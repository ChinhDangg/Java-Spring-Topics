package org.dev.database.l_jpapagination;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LJpaPaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LJpaPaginationApplication.class, args);
    }

    @Bean
    Faker faker() {
        return new Faker();
    }
}
