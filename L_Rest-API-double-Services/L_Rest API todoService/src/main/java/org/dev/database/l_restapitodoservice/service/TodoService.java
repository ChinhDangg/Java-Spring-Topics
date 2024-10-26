package org.dev.database.l_restapitodoservice.service;

import org.dev.database.l_restapitodoservice.model.Todo;
import org.dev.database.l_restapitodoservice.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoService.class);
    private final String DASHBOARD_API_URL = "http://localhost:8081/api/dashboard/todos";
    private final RestTemplate restTemplate;

    public TodoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendToDashboard(List<Todo> todos) {
        ResponseEntity<String> response = restTemplate.postForEntity(DASHBOARD_API_URL, todos, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            LOGGER.info("Successfully sent to the dashboard");
        }
    }
}
