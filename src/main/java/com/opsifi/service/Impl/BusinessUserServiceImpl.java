package com.opsifi.service.Impl;

import com.opsifi.entities.Business;
import com.opsifi.entities.BusinessUsers;
import com.opsifi.model.OnboardingRequestModel;
import com.opsifi.repository.BusinessRepository;
import com.opsifi.repository.BusinessUsersRepository;
import com.opsifi.service.BusinessUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BusinessUserServiceImpl implements BusinessUserService {

    private final BusinessUsersRepository businessUsersRepository;
    private final BusinessRepository businessRepository;
    private final PasswordEncoder passwordEncoder;


    public BusinessUserServiceImpl(BusinessUsersRepository businessUsersRepository, BusinessRepository businessRepository, PasswordEncoder passwordEncoder) {
        this.businessUsersRepository = businessUsersRepository;
        this.businessRepository = businessRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerAdminUser(OnboardingRequestModel onboardingRequestModel, UUID businessId) {
        Optional<Business> business = businessRepository.findByBusinessUniqueId(businessId);

        if (business.isEmpty()) {
            throw new RuntimeException("Business not found with ID: " + businessId);
        }

        if (businessUsersRepository.findByUserName(onboardingRequestModel.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken. Please choose another one.");
        }

        String password = onboardingRequestModel.getPassword();
        if (!isValidPassword(password)) {
            throw new RuntimeException("Password must be at least 8 characters long, contain at least a digit, a special character and an uppercase letter.");
        }

        BusinessUsers user = new BusinessUsers();
        user.setUserName(onboardingRequestModel.getUsername());
        user.setPassword(passwordEncoder.encode(onboardingRequestModel.getPassword()));
        user.setUserType(onboardingRequestModel.getUserType());
        user.setBusiness(business.get());

        businessUsersRepository.save(user);
        return "Admin user registered successfully for business ID: " + businessId;
    }

    private boolean isValidPassword(String password) {
        return password != null &&
                password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*()].*");
    }
}

