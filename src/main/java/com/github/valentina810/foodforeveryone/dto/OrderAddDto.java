package com.github.valentina810.foodforeveryone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class OrderAddDto {

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    @Positive
    private Long statusOrder;

    @NotBlank
    private String deliveryAddress;

    @NotNull
    private Date deliveryDate;

    @NotNull
    private List<DishInOrderDto> dishes;
}