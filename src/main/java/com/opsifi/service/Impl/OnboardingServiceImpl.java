package com.opsifi.service.Impl;

import com.opsifi.entities.Business;
import com.opsifi.model.BusinessAuthModel;
import com.opsifi.repository.BusinessRepository;
import com.opsifi.service.OnboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class OnboardingServiceImpl implements OnboardingService {

    private final BusinessRepository businessRepository;

    public OnboardingServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public UUID registerBusiness(BusinessAuthModel businessAuthModel) {
        Business business = new Business();
        business.setBusinessName(businessAuthModel.getBusinessName());
        business.setBusinessAddress(businessAuthModel.getBusinessAddress());
        business.setBusinessType(businessAuthModel.getBusinessType());
        business.setBusinessSubType(businessAuthModel.getBusinessSubType());
        business.setBusinessUniqueId(UUID.randomUUID());
        business.setActive(true);

        businessRepository.save(business);
        return business.getBusinessUniqueId();
    }

    @Override
    public Optional<Business> getBusinessById(Long id) {
        return Optional.empty();
    }
}