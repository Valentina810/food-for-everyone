package com.github.valentina810.foodforeveryone.service.order;

import com.github.valentina810.foodforeveryone.domain.dish.Dish;
import com.github.valentina810.foodforeveryone.domain.dish.DishInOrder;
import com.github.valentina810.foodforeveryone.domain.order.Order;
import com.github.valentina810.foodforeveryone.domain.order.StatusOrder;
import com.github.valentina810.foodforeveryone.domain.user.User;
import com.github.valentina810.foodforeveryone.dto.DishInOrderDto;
import com.github.valentina810.foodforeveryone.dto.OrderAddDto;
import com.github.valentina810.foodforeveryone.repository.dish.DishInOrderRepository;
import com.github.valentina810.foodforeveryone.repository.dish.DishRepository;
import com.github.valentina810.foodforeveryone.repository.order.OrderRepository;
import com.github.valentina810.foodforeveryone.repository.order.StatusOrderRepository;
import com.github.valentina810.foodforeveryone.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.github.valentina810.foodforeveryone.service.utils.SearchEntityExecutor.findEntityById;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StatusOrderRepository statusOrderRepository;
    private final UserRepository userRepository;
    private final DishRepository dishRepository;
    private final DishInOrderRepository dishInOrderRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Order addOrder(OrderAddDto order) {
        User user = findEntityById(userRepository, order.getUserId(), "Пользователь");
        StatusOrder statusOrder = findEntityById(statusOrderRepository, order.getStatusOrder(), "Статус заказа");

        List<Dish> availableDishes = dishRepository.findAllById(
                        order.getDishes().stream()
                                .map(DishInOrderDto::getIdDish)
                                .collect(Collectors.toSet())
                ).stream()
                .filter(Dish::getIsAvailable)
                .toList();

        Order saveOrder = orderRepository.save(Order.builder()
                .user(user)
                .statusOrder(statusOrder)
                .deliveryAddress(order.getDeliveryAddress())
                .deliveryDate(order.getDeliveryDate())
                .build());

        List<DishInOrder> dishInOrders = order.getDishes().stream()
                .map(dishDto -> {
                    Optional<Dish> optionalDish = availableDishes.stream()
                            .filter(dish -> dish.getId().equals(dishDto.getIdDish()))
                            .findFirst();
                    return optionalDish.map(dish ->
                            DishInOrder.builder()
                                    .dish(dish)
                                    .order(saveOrder)
                                    .count(dishDto.getCount())
                                    .build()
                    );
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        dishInOrderRepository.saveAll(dishInOrders);
        return saveOrder;
    }

    @Override
    public Order findOrderByNumber(Long orderNumber) {
        return orderRepository.getOrderWithDishes(orderNumber);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Order updateOrderStatus(Long orderId, Long statusId) {
        Order order = findEntityById(orderRepository, orderId, "Заказ");
        if (order != null) {
            order.setStatusOrder(findEntityById(statusOrderRepository, statusId, "Статус заказа"));
            return orderRepository.save(order);
        }
        return null;
    }
}