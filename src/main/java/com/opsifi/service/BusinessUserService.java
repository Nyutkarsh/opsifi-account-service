package com.opsifi.service;

import com.opsifi.model.OnboardingRequestModel;

import java.util.UUID;

public interface BusinessUserService {
    String registerAdminUser(OnboardingRequestModel onboardingRequestModel, UUID businessId);
}
