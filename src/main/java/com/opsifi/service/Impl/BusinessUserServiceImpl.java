package com.opsifi.service.Impl;

import com.opsifi.entities.Business;
import com.opsifi.entities.BusinessUsers;
import com.opsifi.model.BusinessUsersAuthModel;
import com.opsifi.repository.BusinessRepository;
import com.opsifi.repository.BusinessUsersRepository;
import com.opsifi.service.BusinessUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BusinessUserServiceImpl implements BusinessUserService {

    private final BusinessUsersRepository businessUsersRepository;
    private final BusinessRepository businessRepository;

    public BusinessUserServiceImpl(BusinessUsersRepository businessUsersRepository, BusinessRepository businessRepository) {
        this.businessUsersRepository = businessUsersRepository;
        this.businessRepository = businessRepository;
    }

    public String registerAdminUser(BusinessUsersAuthModel businessUsersAuthModel, UUID businessId) {
        Optional<Business> business = businessRepository.findByBusinessUniqueId(businessId);

        if (business.isEmpty()) {
            throw new RuntimeException("Business not found with ID: " + businessId);
        }

        BusinessUsers user = new BusinessUsers();
        user.setUserName(businessUsersAuthModel.getUsername());
        user.setPassword(businessUsersAuthModel.getPassword());
        user.setUserType(businessUsersAuthModel.getUserType());
        user.setBusiness(business.get());

        businessUsersRepository.save(user);
        return "Admin user registered successfully for business ID: " + businessId;
    }
}