package org.dev.database.l_restapitodoservice.service;

import org.dev.database.l_restapitodoservice.model.Todo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JsonPlaceholderService {

    private final String TODO_API_URL = "https://jsonplaceholder.typicode.com/todos";
    private final RestTemplate restTemplate;

    public JsonPlaceholderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Todo> getTodos() {
        ResponseEntity<List<Todo>> exchange = restTemplate.exchange(TODO_API_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Todo>>() {
        });
        return exchange.getBody();
    }
}
