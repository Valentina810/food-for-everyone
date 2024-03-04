package com.github.valentina810.foodforeveryone.service.dish;

import com.github.valentina810.foodforeveryone.domain.dish.Dish;
import com.github.valentina810.foodforeveryone.repository.dish.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.valentina810.foodforeveryone.service.utils.SearchEntityExecutor.findEntityById;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
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
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}