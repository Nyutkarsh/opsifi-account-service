package com.opsifi.controller;

import com.opsifi.entities.Business;
import com.opsifi.enums.BusinessCategory;
import com.opsifi.enums.BusinessUsersCategory;
import com.opsifi.model.OnboardingRequestModel;
import com.opsifi.model.OnboardingResponseModel;
import com.opsifi.service.OnboardingService;
import com.opsifi.service.BusinessUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/onboarding")
public class OnboardingController {

    private final OnboardingService onboardingService;
    private final BusinessUserService businessUserService;

    public OnboardingController(OnboardingService onboardingService, BusinessUserService businessUserService) {
        this.onboardingService = onboardingService;
        this.businessUserService = businessUserService;
    }

    @PostMapping("/new")
    public ResponseEntity<OnboardingResponseModel> registerBusinessWithAdmin(
            @Valid @RequestBody OnboardingRequestModel onboardingRequestModel) {

        Business savedBusiness = onboardingService.onboardBusiness(onboardingRequestModel);

        return ResponseEntity.ok(new OnboardingResponseModel("Business Registered Successfully [Unique ID: "+savedBusiness.getBusinessUniqueId()+"], Please check your email for verification and further instructions.", "Success", HttpStatus.OK.toString()));
    }
}
