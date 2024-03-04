package com.github.valentina810.foodforeveryone.controller.dish;

import com.github.valentina810.foodforeveryone.domain.dish.DishInOrder;
import com.github.valentina810.foodforeveryone.dto.DishInOrderAddDto;
import com.github.valentina810.foodforeveryone.service.dish.DishInOrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dishInOrders")
@RequiredArgsConstructor
@Validated
public class DishInOrderController {

    private final DishInOrderService dishInOrderService;

    @PostMapping
    public DishInOrder addDishToOrder(@Valid @RequestBody DishInOrderAddDto dishInOrderAddDto) {
        return dishInOrderService.addDishToOrder(dishInOrderAddDto);
    }

    @PatchMapping("/{id}")
    public DishInOrder updateDishToOrder(@PathVariable("id") Long id, @Positive @RequestParam("count") Integer count) {
        return dishInOrderService.updateDishToOrder(id, count);
    }

    @DeleteMapping("/{id}")
    public void removeDishFromOrder(@PathVariable("id") Long id) {
        dishInOrderService.removeDishFromOrder(id);
    }

    @GetMapping("/search/{orderId}")
    public List<DishInOrder> getDishesByOrderId(@PathVariable("orderId") Long orderId) {
        return dishInOrderService.getDishesByOrderId(orderId);
    }
}