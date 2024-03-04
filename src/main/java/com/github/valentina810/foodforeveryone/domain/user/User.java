package com.github.valentina810.foodforeveryone.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.valentina810.foodforeveryone.domain.donation.Donation;
import com.github.valentina810.foodforeveryone.domain.order.Order;
import jakarta.persistence.CascadeType;
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

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "user_role_id", nullable = false)
    private UserRole userRole;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    private String phone;

    private String email;

    private String login;

    @JsonIgnore
    private String password;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> order;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Donation> donations;

    @ManyToOne
    @JoinColumn(name = "reason_blocked_id")
    private ReasonBlocked reasonBlocked;
}