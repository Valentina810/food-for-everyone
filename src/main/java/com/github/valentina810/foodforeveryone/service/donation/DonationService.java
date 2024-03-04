package com.github.valentina810.foodforeveryone.service.donation;

import com.github.valentina810.foodforeveryone.domain.donation.Donation;
import com.github.valentina810.foodforeveryone.dto.DonationAddDto;

import java.util.List;

public interface DonationService {
    Donation addDonation(DonationAddDto donation);

    List<Donation> getDonationsByUserId(Long userId);

    Donation getDonationById(Long donationId);
}