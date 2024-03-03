package com.github.valentina810.foodforeveryone.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class DonationAddDto {
    @NotNull
    @Positive
    private Long userId;
    @NotNull
    @Positive
    private Double amount;

    @NotNull
    @Positive
    private Long paymentMethodId;
}