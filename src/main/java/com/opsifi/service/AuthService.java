package com.opsifi.service;

import com.opsifi.model.LoginRequestModel;
import com.opsifi.model.LoginResponseModel;

public interface AuthService {
    LoginResponseModel authenticateUser(LoginRequestModel request);
}
