package com.opsifi.service;

import com.opsifi.entities.Business;
import com.opsifi.model.BusinessAuthModel;

import java.util.Optional;
import java.util.UUID;


public interface OnboardingService {
    Business registerBusiness(BusinessAuthModel businessAuthModel);
    Optional<Business> getBusinessById(Long id);
}
