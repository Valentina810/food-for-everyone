package com.github.valentina810.foodforeveryone.repository.dish;

import com.github.valentina810.foodforeveryone.domain.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findByName(String name);
}