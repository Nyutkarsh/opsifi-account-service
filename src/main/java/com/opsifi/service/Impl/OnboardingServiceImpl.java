package com.opsifi.service.Impl;

import com.opsifi.entities.Business;
import com.opsifi.model.OnboardingRequestModel;
import com.opsifi.repository.BusinessRepository;
import com.opsifi.service.BusinessUserService;
import com.opsifi.service.OnboardingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class OnboardingServiceImpl implements OnboardingService {
    private final BusinessRepository businessRepository;
    private final BusinessUserService businessUserService;

    public OnboardingServiceImpl(BusinessRepository businessRepository, BusinessUserService businessUserService) {
        this.businessRepository = businessRepository;
        this.businessUserService = businessUserService;
    }

    @Override
    @Transactional
    public Business onboardBusiness(OnboardingRequestModel onboardingRequestModel) {

        Business business = new Business();
        business.setBusinessName(onboardingRequestModel.getBusinessName());
        business.setBusinessAddress(onboardingRequestModel.getBusinessAddress());
        business.setBusinessType(onboardingRequestModel.getBusinessType());
        business.setBusinessSubType(onboardingRequestModel.getBusinessSubType());
        business.setBusinessUniqueId(UUID.randomUUID());
        business.setActive(true);

        business = businessRepository.save(business);

        businessUserService.registerAdminUser(onboardingRequestModel, business.getBusinessUniqueId());

        return business;
    }

    @Override
    public Optional<Business> getBusinessById(Long id) {
        return Optional.empty();
    }
}