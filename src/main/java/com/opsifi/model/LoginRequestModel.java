package com.opsifi.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestModel {
    private String username;
    private String password;

    public LoginRequestModel() {}

    public LoginRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
