package com.cft.apizza.controller;

import com.cft.apizza.entities.Pizza;
import com.cft.apizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<Pizza>> getAllPizzas() {
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Integer id) {
        Optional<Pizza> pizza = pizzaService.getPizzaById(id);
        return pizza.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pizza> createPizza(@PathVariable Pizza pizza) {
        if (!pizzaService.existsPizza(pizza.getId())) {
            Pizza newPizza = pizzaService.savePizza(pizza);
            return new ResponseEntity<>(newPizza, HttpStatus.CREATED);
        }
        Pizza newPizza = pizzaService.savePizza(pizza);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Pizza> updatePizza(@PathVariable Pizza pizza) {
        if (pizzaService.existsPizza(pizza.getId())) {
            Pizza newPizza = pizzaService.savePizza(pizza);
            return ResponseEntity.ok(pizzaService.savePizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Integer id) {
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }


}
