package com.github.valentina810.foodforeveryone.repository.order;

import com.github.valentina810.foodforeveryone.domain.order.StatusOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusOrderRepository extends JpaRepository<StatusOrder, Long> {
}