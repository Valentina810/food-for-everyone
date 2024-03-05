package com.github.valentina810.foodforeveryone.service.dish;

import com.github.valentina810.foodforeveryone.domain.dish.Dish;
import com.github.valentina810.foodforeveryone.domain.dish.DishInOrder;
import com.github.valentina810.foodforeveryone.domain.order.Order;
import com.github.valentina810.foodforeveryone.dto.DishInOrderAddDto;
import com.github.valentina810.foodforeveryone.repository.dish.DishInOrderRepository;
import com.github.valentina810.foodforeveryone.repository.dish.DishRepository;
import com.github.valentina810.foodforeveryone.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.github.valentina810.foodforeveryone.service.utils.SearchEntityExecutor.findEntityById;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DishInOrderServiceImpl implements DishInOrderService {

    private final DishInOrderRepository dishInOrderRepository;
    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public DishInOrder addDishToOrder(DishInOrderAddDto dishInOrderAddDto) {
        Dish dish = findEntityById(dishRepository, dishInOrderAddDto.getDishId(), "Блюдо");
        Order order = findEntityById(orderRepository, dishInOrderAddDto.getOrderId(), "Заказ");
        return dishInOrderRepository.save(DishInOrder.builder()
                .dish(dish)
                .order(order)
                .count(dishInOrderAddDto.getCount())
                .build());
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void removeDishFromOrder(Long id) {
        dishInOrderRepository.deleteById(id);
    }

    @Override
    public List<DishInOrder> getDishesByOrderId(Long orderId) {
        return dishInOrderRepository.findByOrderId(orderId);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public DishInOrder updateDishToOrder(Long id, Integer count) {
        DishInOrder dishInOrder = findEntityById(dishInOrderRepository, id, "Блюдо в заказе");
        dishInOrder.setCount(count);
        dishInOrderRepository.save(dishInOrder);
        return dishInOrder;
    }
}