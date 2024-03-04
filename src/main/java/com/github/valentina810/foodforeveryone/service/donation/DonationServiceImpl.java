package com.github.valentina810.foodforeveryone.service.donation;

import com.github.valentina810.foodforeveryone.domain.donation.Donation;
import com.github.valentina810.foodforeveryone.dto.DonationAddDto;
import com.github.valentina810.foodforeveryone.repository.donation.DonationRepository;
import com.github.valentina810.foodforeveryone.repository.donation.PaymentMethodRepository;
import com.github.valentina810.foodforeveryone.repository.user.UserRepository;
import com.github.valentina810.foodforeveryone.service.utils.SearchEntityExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;

    @Override
    public Donation addDonation(DonationAddDto donationAddDto) {
        return donationRepository.save(Donation.builder()
                .user(SearchEntityExecutor.findEntityById(userRepository, donationAddDto.getUserId(), "Пользователь"))
                .paymentMethod(SearchEntityExecutor.findEntityById(paymentMethodRepository, donationAddDto.getPaymentMethodId(), "Метод оплаты"))
                .date(new Date())
                .amount(donationAddDto.getAmount())
                .build());
    }

    @Override
    public List<Donation> getDonationsByUserId(Long userId) {
        return donationRepository.findByUserId(userId);
    }

    @Override
    public Donation getDonationById(Long donationId) {
        return donationRepository.findById(donationId).orElse(null);
    }
}