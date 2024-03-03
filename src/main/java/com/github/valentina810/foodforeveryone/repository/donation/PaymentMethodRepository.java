package com.github.valentina810.foodforeveryone.repository.donation;

import com.github.valentina810.foodforeveryone.domain.donation.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}