package org.dev.database.l_extendannotations.controller;

import jakarta.annotation.PostConstruct;
import org.dev.database.l_extendannotations.annotation.GET;
import org.dev.database.l_extendannotations.annotation.POST;
import org.dev.database.l_extendannotations.model.Coffee;
import org.dev.database.l_extendannotations.model.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    private final List<Coffee> coffees = new ArrayList<>();

    @GET
    public List<Coffee> findAll() {
        return coffees;
    }

    @GET("/{id}")
    public Optional<Coffee> findOne(@PathVariable Integer id) {
        return coffees.stream().filter(coffee -> Objects.equals(coffee.id(), id)).findFirst();
    }

    @POST
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Coffee coffee) {
        coffees.add(coffee);
    }

    @PostConstruct
    private void init() {
        coffees.add(new Coffee(1, "Caffe Americano", Size.GRANDE));
        coffees.add(new Coffee(2, "Caffe Latte", Size.VENTI));
        coffees.add(new Coffee(3, "Caffe Caramel Macchito", Size.TALL));
    }

    // to check process running at port in terminal: lsof -i :8080
    // kill it: kill -9 "PID"
}
