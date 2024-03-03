package com.github.valentina810.foodforeveryone.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class DishInOrderAddDto {
    @NotNull
    @Positive
    private Long orderId;
    @NotNull
    @Positive
    private Long dishId;
    @NotNull
    @Positive
    private Integer count;
}