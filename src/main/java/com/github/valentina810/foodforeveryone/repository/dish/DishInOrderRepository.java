package com.github.valentina810.foodforeveryone.repository.dish;

import com.github.valentina810.foodforeveryone.domain.dish.DishInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishInOrderRepository extends JpaRepository<DishInOrder, Long> {
}