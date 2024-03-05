package com.github.valentina810.foodforeveryone.service.donation;

import com.github.valentina810.foodforeveryone.domain.donation.Donation;
import com.github.valentina810.foodforeveryone.dto.DonationAddDto;
import com.github.valentina810.foodforeveryone.repository.donation.DonationRepository;
import com.github.valentina810.foodforeveryone.repository.donation.PaymentMethodRepository;
import com.github.valentina810.foodforeveryone.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.github.valentina810.foodforeveryone.service.utils.SearchEntityExecutor.findEntityById;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Donation addDonation(DonationAddDto donationAddDto) {
        return donationRepository.save(Donation.builder()
                .user(findEntityById(userRepository, donationAddDto.getUserId(), "Пользователь"))
                .paymentMethod(findEntityById(paymentMethodRepository, donationAddDto.getPaymentMethodId(), "Метод оплаты"))
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
        return findEntityById(donationRepository, donationId, "Пожертвование");
    }
}