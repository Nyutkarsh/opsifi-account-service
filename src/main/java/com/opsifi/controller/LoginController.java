package com.opsifi.controller;

import com.opsifi.model.LoginRequestModel;
import com.opsifi.model.LoginResponseModel;
import com.opsifi.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseModel> login(@RequestBody LoginRequestModel request) {
        return ResponseEntity.ok(authService.authenticateUser(request));
    }
}
