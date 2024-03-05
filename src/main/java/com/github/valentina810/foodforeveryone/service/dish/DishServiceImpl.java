package com.github.valentina810.foodforeveryone.service.dish;

import com.github.valentina810.foodforeveryone.domain.dish.Dish;
import com.github.valentina810.foodforeveryone.repository.dish.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.github.valentina810.foodforeveryone.service.utils.SearchEntityExecutor.findEntityById;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish findDishByName(String name) {
        return dishRepository.findByName(name);
    }

    @Override
    public Dish findDishById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dish> findAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Dish updateDish(Long id, Dish dish) {
        Dish existingDish = findEntityById(dishRepository, id, "Блюдо");
        if (existingDish != null) {
            existingDish.setName(dish.getName());
            existingDish.setDescription(dish.getDescription());
            return dishRepository.save(existingDish);
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}