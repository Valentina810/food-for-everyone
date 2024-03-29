package com.github.valentina810.foodforeveryone.service.dish;

import com.github.valentina810.foodforeveryone.domain.dish.Dish;

import java.util.List;

public interface DishService {
    Dish addDish(Dish dish);

    Dish findDishByName(String name);

    Dish findDishById(Long id);

    List<Dish> findAllDishes();

    Dish updateDish(Long id, Dish dish);

    void deleteDish(Long id);
}