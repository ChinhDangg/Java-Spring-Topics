package org.dev.database.l_restapidashboardservice.controller;

import org.dev.database.l_restapidashboardservice.model.Todo;
import org.dev.database.l_restapidashboardservice.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashBoardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DashBoardController.class);

    private final TodoRepository todoRepository;

    public DashBoardController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/todos")
    public void loadTodos(@RequestBody List<Todo> todos) {
        todoRepository.saveAll(todos);
        LOGGER.info("Todos loaded");
    }
}
