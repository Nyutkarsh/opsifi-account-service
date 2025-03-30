package com.opsifi.controller;

import com.opsifi.enums.BusinessCategory;
import com.opsifi.enums.BusinessUsersCategory;
import com.opsifi.model.BusinessAuthModel;
import com.opsifi.model.BusinessUsersAuthModel;
import com.opsifi.service.OnboardingService;
import com.opsifi.service.BusinessUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
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

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerBusinessWithAdmin(
            @RequestBody Map<String, Object> requestBody) {

        BusinessAuthModel businessAuthModel = new BusinessAuthModel(
                (String) requestBody.get("businessName"),
                (String) requestBody.get("businessAddress"),
                BusinessCategory.valueOf((String) requestBody.get("businessType")),
                (String) requestBody.get("businessSubType")
        );

        UUID businessId = onboardingService.registerBusiness(businessAuthModel);


        BusinessUsersAuthModel businessUsersAuthModel = new BusinessUsersAuthModel(
                (String) requestBody.get("adminName"),
                (String) requestBody.get("adminPassword"),
                (String) requestBody.get("adminUsername"),
                BusinessUsersCategory.valueOf((String) requestBody.get("userType"))
        );

        String userMessage = businessUserService.registerAdminUser(businessUsersAuthModel, businessId);

        return ResponseEntity.ok(Map.of("business", "Business Registered Successfully", "adminUser", userMessage));
    }
}
