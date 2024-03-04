package com.github.valentina810.foodforeveryone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class UserCreateDto {
    @NotNull
    @Positive
    private Long idUserType;

    @NotNull
    @Positive
    private Long idUserRole;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;

    @NotBlank
    private String email;

    @NotBlank
    private String login;

    @NotBlank
    private String password;
}