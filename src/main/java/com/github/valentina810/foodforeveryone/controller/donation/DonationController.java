/***
 ***   This file is generated by JAIG at 00:59 05.03.2024
 ***   As a result of parsing GPT response
 ***   04_swagger_description-response
 ***/
package com.github.valentina810.foodforeveryone.controller.donation;

import com.github.valentina810.foodforeveryone.domain.donation.Donation;
import com.github.valentina810.foodforeveryone.dto.DonationAddDto;
import com.github.valentina810.foodforeveryone.service.donation.DonationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Создание пожертвования", description = "Создает новое пожертвование")
    @ApiResponse(responseCode = "200", description = "Пожертвование успешно создано")
    @PostMapping
    public Donation addDonation(@RequestBody @Valid DonationAddDto donationAddDto) {
        return donationService.addDonation(donationAddDto);
    }

    @Operation(summary = "Поиск пожертвований по Id пользователя", description = "Возвращает список пожертвований, сделанных пользователем с указанным Id")
    @ApiResponse(responseCode = "200", description = "Список пожертвований успешно получен")
    @GetMapping("/search")
    public List<Donation> getDonationsByUserId(@RequestParam("userId") Long userId) {
        return donationService.getDonationsByUserId(userId);
    }

    @Operation(summary = "Получение информации о пожертвовании", description = "Возвращает информацию о пожертвовании с указанным Id")
    @ApiResponse(responseCode = "200", description = "Информация о пожертвовании успешно получена")
    @GetMapping("/{donationId}")
    public Donation getDonationById(@PathVariable("donationId") Long donationId) {
        return donationService.getDonationById(donationId);
    }
}