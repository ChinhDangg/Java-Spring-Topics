package dev.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tasks", repository.findAll());
        return "index";
    }

    @PostMapping("/add-task")
    public String addTask(@RequestParam String description, Model model) {
        Task newTask = new Task(description);
        repository.create(newTask);
        model.addAttribute("task", newTask);
        return "task-row";
    }

    @DeleteMapping("/delete-task/{id}")
    @ResponseBody // Delete mapping need a response status
    public void deleteTask(@PathVariable String id) {
        boolean removed = repository.remove(id);
    }
}
