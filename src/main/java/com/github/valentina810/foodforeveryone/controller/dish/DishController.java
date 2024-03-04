package com.github.valentina810.foodforeveryone.controller.dish;

import com.github.valentina810.foodforeveryone.domain.dish.Dish;
import com.github.valentina810.foodforeveryone.service.dish.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @PostMapping
    public Dish addDish(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @GetMapping("/search")
    public Dish findDishByName(@RequestParam String name) {
        return dishService.findDishByName(name);
    }

    @GetMapping("/{id}")
    public Dish findDishById(@PathVariable Long id) {
        return dishService.findDishById(id);
    }

    @GetMapping
    public List<Dish> findAllDishes() {
        return dishService.findAllDishes();
    }

    @PutMapping("/{id}")
    public Dish updateDish(@PathVariable Long id, @RequestBody Dish dish) {
        return dishService.updateDish(id, dish);
    }

    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }
}