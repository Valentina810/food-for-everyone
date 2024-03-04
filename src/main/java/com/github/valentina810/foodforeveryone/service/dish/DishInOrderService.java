package com.github.valentina810.foodforeveryone.service.dish;

import com.github.valentina810.foodforeveryone.domain.dish.DishInOrder;
import com.github.valentina810.foodforeveryone.dto.DishInOrderAddDto;

import java.util.List;

public interface DishInOrderService {
    DishInOrder addDishToOrder(DishInOrderAddDto dishInOrderAddDto);

    void removeDishFromOrder(Long id);

    List<DishInOrder> getDishesByOrderId(Long orderId);

    DishInOrder updateDishToOrder(Long id, Integer count);
}