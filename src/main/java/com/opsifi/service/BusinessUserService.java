package com.opsifi.service;

import com.opsifi.model.BusinessUsersAuthModel;

import java.util.UUID;

public interface BusinessUserService {
    String registerAdminUser(BusinessUsersAuthModel businessUsersAuthModel, UUID businessId);
}
