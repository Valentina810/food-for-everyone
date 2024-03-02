package com.github.valentina810.foodforeveryone.repository.donation;

import com.github.valentina810.foodforeveryone.domain.donation.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}