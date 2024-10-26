package org.dev.database.l_restapitodoservice;

import org.dev.database.l_restapitodoservice.model.Todo;
import org.dev.database.l_restapitodoservice.repository.TodoRepository;
import org.dev.database.l_restapitodoservice.service.JsonPlaceholderService;
import org.dev.database.l_restapitodoservice.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@SpringBootApplication
public class LRestApiTodoServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(LRestApiTodoServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LRestApiTodoServiceApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(JsonPlaceholderService jsonPlaceholderService, TodoRepository repository, TodoService service) {
        return args -> {
            // when the application loads, get the 200 todos from json placeholder
            List<Todo> todos = jsonPlaceholderService.getTodos();
            // once we have the todos, persist them to the db
            repository.saveAll(todos);
            LOGGER.info("Saved {} todos in the database", todos.size());

            // push this information to our dashboard service
            service.sendToDashboard(todos);
        };
    }
}
