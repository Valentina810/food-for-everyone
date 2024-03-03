package com.github.valentina810.foodforeveryone.service.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.repository.JpaRepository;

@UtilityClass
public class SearchEntityExecutor {
    public static <T> T findEntityById(JpaRepository<T, Long> repository, Long id, String entityName) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("%s с id %d не найден!", entityName, id)));
    }
}