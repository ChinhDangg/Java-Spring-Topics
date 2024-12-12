package org.dev.backend.l_restapidomainclassconverter;

import org.apache.catalina.core.ApplicationContext;
import org.dev.backend.l_restapidomainclassconverter.model.Post;
import org.dev.backend.l_restapidomainclassconverter.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LRestApiDomainClassConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LRestApiDomainClassConverterApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository postRepository) {
        return args -> {
            postRepository.save(new Post(1, "Hello World", "Welcome to my post"));
            postRepository.save(new Post(2, "Hello Spring", "Welcome to my post"));
        };
    }
}
