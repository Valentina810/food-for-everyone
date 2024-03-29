package com.github.valentina810.foodforeveryone.repository.order;

import com.github.valentina810.foodforeveryone.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "from Order ord  " +
            "left join fetch ord.dishes  " +
            "left join fetch ord.statusOrder  " +
            "where ord.id=:orderId")
    Order getOrderWithDishes(Long orderId);
}