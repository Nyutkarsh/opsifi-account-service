package com.opsifi.service;

import com.opsifi.entities.Business;
import com.opsifi.model.OnboardingRequestModel;

import java.util.Optional;


public interface OnboardingService {
    Business onboardBusiness(OnboardingRequestModel onboardingRequestModel);
    Optional<Business> getBusinessById(Long id);
}
