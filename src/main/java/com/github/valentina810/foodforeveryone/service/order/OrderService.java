package com.github.valentina810.foodforeveryone.service.order;

import com.github.valentina810.foodforeveryone.domain.order.Order;
import com.github.valentina810.foodforeveryone.dto.OrderAddDto;

public interface OrderService {
    Order addOrder(OrderAddDto order);

    Order findOrderByNumber(Long orderNumber);

    Order updateOrderStatus(Long orderId, Long statusId);
}