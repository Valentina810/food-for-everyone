package com.github.valentina810.foodforeveryone.controller.donation;

import com.github.valentina810.foodforeveryone.domain.donation.Donation;
import com.github.valentina810.foodforeveryone.dto.DonationAddDto;
import com.github.valentina810.foodforeveryone.service.donation.DonationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/donations")
@RequiredArgsConstructor
@Validated
public class DonationController {

    private final DonationService donationService;

    @PostMapping
    public Donation addDonation(@RequestBody @Valid DonationAddDto donationAddDto) {
        return donationService.addDonation(donationAddDto);
    }

    @GetMapping("/search")
    public List<Donation> getDonationsByUserId(@RequestParam("userId") Long userId) {
        return donationService.getDonationsByUserId(userId);
    }

    @GetMapping("/{donationId}")
    public Donation getDonationById(@PathVariable("donationId") Long donationId) {
        return donationService.getDonationById(donationId);
    }
}