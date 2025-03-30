package com.opsifi.service.Impl;

import com.opsifi.model.LoginRequestModel;
import com.opsifi.model.LoginResponseModel;
import com.opsifi.repository.BusinessUsersRepository;
import com.opsifi.util.JwtUtil;
import com.opsifi.entities.BusinessUsers;
import com.opsifi.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final BusinessUsersRepository businessUsersRepository;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(AuthenticationManager authenticationManager, BusinessUsersRepository businessUsersRepository, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.businessUsersRepository = businessUsersRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponseModel authenticateUser(LoginRequestModel request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        Optional<BusinessUsers> userOptional = businessUsersRepository.findByUserName(request.getUsername());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        BusinessUsers user = userOptional.get();
        String token = jwtUtil.generateToken(user.getUserName());

        return new LoginResponseModel(token, user.getUserName(), user.getUserType().name());
    }
}
