package com.github.valentina810.foodforeveryone.repository.order;

import com.github.valentina810.foodforeveryone.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}