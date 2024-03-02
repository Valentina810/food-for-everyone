package com.github.valentina810.foodforeveryone.domain.user;

public class User {
    private Long id;
    private UserType userType;
    private UserRole userRole;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String login;
    private String password;
    private Boolean isBlocked;
    private ReasonBlocked reasonBlocked;
}