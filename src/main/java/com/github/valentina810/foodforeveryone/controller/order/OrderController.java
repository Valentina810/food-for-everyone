package com.github.valentina810.foodforeveryone.controller.order;

import com.github.valentina810.foodforeveryone.domain.order.Order;
import com.github.valentina810.foodforeveryone.dto.OrderAddDto;
import com.github.valentina810.foodforeveryone.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody OrderAddDto orderAddDto) {
        Order newOrder = orderService.addOrder(orderAddDto);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<Order> findOrderByNumber(@RequestParam("orderNumber") Long orderNumber) {
        Order order = orderService.findOrderByNumber(orderNumber);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{orderId}/{statusId}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable("orderId") Long orderId,
                                                   @PathVariable("statusId") Long statusId) {
        Order updatedOrder = orderService.updateOrderStatus(orderId, statusId);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}