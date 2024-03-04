package com.github.valentina810.foodforeveryone.domain.dish;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dish", nullable = false, unique = true)
    private Long id;

    private String name;

    private String description;

    private Double price;

    @Column(name = "is_available")
    private Boolean isAvailable;
}
