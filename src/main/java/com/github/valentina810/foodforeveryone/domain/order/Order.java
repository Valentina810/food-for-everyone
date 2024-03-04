package com.github.valentina810.foodforeveryone.domain.order;

import com.github.valentina810.foodforeveryone.domain.dish.DishInOrder;
import com.github.valentina810.foodforeveryone.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_order_id", nullable = false)
    private StatusOrder statusOrder;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @OneToMany(mappedBy = "order")
    private List<DishInOrder> dishes;
}