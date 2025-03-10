package dev.test;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Task {

    private final String id;
    private final String description;

    public Task(String description) {
        this.description = description;
        this.id = UUID.randomUUID().toString();
    }
}
