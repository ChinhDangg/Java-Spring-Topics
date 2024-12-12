package org.dev.backend.l_springsecurityjpaauthentication;

import org.dev.backend.l_springsecurityjpaauthentication.model.Post;
import org.dev.backend.l_springsecurityjpaauthentication.model.User;
import org.dev.backend.l_springsecurityjpaauthentication.repository.PostRepository;
import org.dev.backend.l_springsecurityjpaauthentication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class LSpringSecurityJpaAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LSpringSecurityJpaAuthenticationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository postRepository, UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            Post post1 = new Post("Title 1", "Slug 1", "Content 1", "Author 1");
            Post post2 = new Post("Title 2", "Slug 2", "Content 2", "Author 2");
            Post post3 = new Post("Title 3", "Slug 3", "Content 3", "Author 3");
            postRepository.saveAll(List.of(post1, post2, post3));


            User user1 = new User("user", encoder.encode("password"), "USER");
            User user2 = new User("user2", encoder.encode("password"), "USER");
            User user3 = new User("admin", encoder.encode("password"), "USER,ADMIN");
            userRepository.saveAll(List.of(user1, user2, user3));
        };
    }

}
