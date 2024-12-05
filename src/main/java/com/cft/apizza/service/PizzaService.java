package com.cft.apizza.service;

import com.cft.apizza.entities.Pizza;
import com.cft.apizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> getPizzaById(Integer id) {
        return pizzaRepository.findById(id);
    }

    public Pizza savePizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public void deletePizza(Integer id) {
        pizzaRepository.deleteById(id);
    }

    public boolean existsPizza(Integer id) {
        if (id == null) {
            return false; // O manejar el caso de otra manera
        }
        return this.pizzaRepository.existsById(id);
    }

    public List<Pizza> findVegetarian() {
        return pizzaRepository.findVegetarian();
    }

    public List<Pizza> findIngredient(String ingredient) {
        return pizzaRepository.findIngredient(ingredient);
    }

    public List<Pizza> findAvailable() {
        return pizzaRepository.findAvailable();
    }

    public List<Pizza> findByPrice(Integer price) {
        return pizzaRepository.findByPrice(price);
    }

    public List<Pizza> getAvailable() {
        return pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public List<Pizza> contains(String ingredient) {
        return pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }

    public List<Pizza> notContains(String ingredient) {
        return pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    public List<Pizza> lessThan(Integer price) {
        return pizzaRepository.findAllByPriceLessThanEqualOrderByPriceAsc(price);
    }

    public Integer veganCount() {
        return pizzaRepository.countByVeganTrue();
    }

}
