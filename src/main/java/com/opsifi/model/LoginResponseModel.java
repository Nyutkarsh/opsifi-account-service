package com.opsifi.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponseModel {
    private String token;
    private String username;
    private String role;

    public LoginResponseModel(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

}
