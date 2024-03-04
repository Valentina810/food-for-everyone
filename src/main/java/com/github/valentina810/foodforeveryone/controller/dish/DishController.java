/***
***   This file is generated by JAIG at 00:39 05.03.2024
***   As a result of parsing GPT response 
***   04_swagger_description-response
***/
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @Operation(summary = "Создание блюда")
    @ApiResponse(responseCode = "200", description = "Блюдо успешно создано")
    @PostMapping
    public Dish addDish(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @Operation(summary = "Поиск блюда по названию")
    @ApiResponse(responseCode = "200", description = "Блюдо найдено")
    @GetMapping("/search")
    public Dish findDishByName(@RequestParam String name) {
        return dishService.findDishByName(name);
    }

    @Operation(summary = "Получение блюда по id")
    @ApiResponse(responseCode = "200", description = "Блюдо найдено")
    @GetMapping("/{id}")
    public Dish findDishById(@PathVariable Long id) {
        return dishService.findDishById(id);
    }

    @Operation(summary = "Получение всех блюд")
    @ApiResponse(responseCode = "200", description = "Список блюд получен")
    @GetMapping
    public List<Dish> findAllDishes() {
        return dishService.findAllDishes();
    }

    @Operation(summary = "Обновление блюда")
    @ApiResponse(responseCode = "200", description = "Блюдо успешно обновлено")
    @PutMapping("/{id}")
    public Dish updateDish(@PathVariable Long id, @RequestBody Dish dish) {
        return dishService.updateDish(id, dish);
    }

    @Operation(summary = "Удаление блюда по id")
    @ApiResponse(responseCode = "200", description = "Блюдо успешно удалено")
    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }
}