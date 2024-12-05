package com.cft.apizza.repository;

import com.cft.apizza.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM PIZZA WHERE VEGETARIAN = 1")
    List<Pizza> findVegetarian();

    @Query(nativeQuery = true, value = "SELECT * FROM PIZZA WHERE DESCRIPTION LIKE %:ingredient%")
    List<Pizza> findIngredient(@Param("ingredient") String ingredient);

    @Query(nativeQuery = true, value = "SELECT * FROM PIZZA WHERE AVAILABLE = 1")
    List<Pizza> findAvailable();

    @Query(nativeQuery = true, value = "SELECT * FROM PIZZA WHERE PRICE = :price")
    List<Pizza> findByPrice(@Param("price") Integer price);

    List<Pizza> findAllByAvailableTrueOrderByPrice();

    List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String ingredient);

    List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String ingredient);

    List<Pizza> findAllByPriceLessThanEqualOrderByPriceAsc(Integer price);

    Integer countByVeganTrue();

}
