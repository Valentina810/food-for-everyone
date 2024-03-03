package com.github.valentina810.foodforeveryone.repository.dish;

import com.github.valentina810.foodforeveryone.domain.dish.DishInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishInOrderRepository extends JpaRepository<DishInOrder, Long> {

    @Query(value = "from DishInOrder dio "+
            "where dio.orders.id=:orderId")
    List<DishInOrder> findByOrderId(Long orderId);
}