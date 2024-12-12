package org.dev.security.l_springsecuritycors.controller;

import com.fasterxml.jackson.databind.cfg.ConfigFeature;
import org.dev.security.l_springsecuritycors.model.Coffee;
import org.dev.security.l_springsecuritycors.model.Size;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/coffee")
// @CrossOrigin(origins = "http://localhost:3000") // can use class annotation
public class CoffeeController {

    private final List<Coffee> coffeeList = new ArrayList<Coffee>();

    public CoffeeController() {
        coffeeList.add(new Coffee(1, "Caffe Americano", Size.GRANDE));
        coffeeList.add(new Coffee(2, "Caffe Americano", Size.GRANDE));
        coffeeList.add(new Coffee(3, "Caffe Americano", Size.GRANDE));
    }

    @GetMapping
    public List<Coffee> getCoffees() {
        return coffeeList;
    }

    // @CrossOrigin(origins = "http://localhost:3000") // can be more granular at the method level
    @DeleteMapping
    public void deleteCoffees(Integer id) {
        coffeeList.removeIf(coffee -> coffee.id().equals(id));
    }



}
