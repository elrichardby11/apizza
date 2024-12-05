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
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) {
        if (!pizzaService.existsPizza(pizza.getId())) {
            Pizza newPizza = pizzaService.savePizza(pizza);
            return new ResponseEntity<>(newPizza, HttpStatus.CREATED);
        }
        Pizza newPizza = pizzaService.savePizza(pizza);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Pizza> updatePizza(@RequestBody Pizza pizza) {
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

    @GetMapping("/vegetarian")
    public ResponseEntity<List<Pizza>> getVegetarian() {
        return ResponseEntity.ok(pizzaService.findVegetarian());
    }

    @GetMapping("/find_ingredient/{ingredient}")
    public ResponseEntity<List<Pizza>> findIngredient(@PathVariable String ingredient) {
        return ResponseEntity.ok(pizzaService.findIngredient(ingredient));
    }

    @GetMapping("/available1")
    public ResponseEntity<List<Pizza>> available() {
        return ResponseEntity.ok(pizzaService.findAvailable());
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Pizza>> price(@PathVariable Integer price) {
        return ResponseEntity.ok(pizzaService.findByPrice(price));
    }

    @GetMapping("/available2")
    public ResponseEntity<List<Pizza>> getAvailable() {
        return ResponseEntity.ok(pizzaService.getAvailable());
    }

    @GetMapping("/contains/{ingredient}")
    public ResponseEntity<List<Pizza>> contains(@PathVariable String ingredient) {
        return ResponseEntity.ok(pizzaService.contains(ingredient));
    }

    @GetMapping("/not_contains/{ingredient}")
    public ResponseEntity<List<Pizza>> notContains(@PathVariable String ingredient) {
        return ResponseEntity.ok(pizzaService.notContains(ingredient));
    }

    @GetMapping("/less_than/{price}")
    public ResponseEntity<List<Pizza>> lessThan(@PathVariable Integer price) {
        return ResponseEntity.ok(pizzaService.lessThan(price));
    }

    @GetMapping("/vegan_count")
    public ResponseEntity<Integer> veganCount() {
        return ResponseEntity.ok(pizzaService.veganCount());
    }

}
