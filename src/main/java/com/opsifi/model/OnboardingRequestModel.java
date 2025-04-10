package com.opsifi.model;

import com.opsifi.enums.BusinessCategory;
import com.opsifi.enums.BusinessUsersCategory;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnboardingRequestModel {

    @NotBlank(message = "Business name can not be empty!")
    private String businessName;

    @NotBlank(message = "Business address can not be empty!")
    private String businessAddress;

    @NotNull(message = "Business category can not be empty!")
    private BusinessCategory businessType;

    @NotBlank(message = "Business subtype can not be empty!")
    private String businessSubType;

    @NotBlank(message = "Business country can not be empty!")
    private String businessCountry;

    @NotBlank(message = "Admin name can not be empty!")
    private String adminName;

    @NotBlank(message = "Username can not be empty!")
    private String username;

    @NotBlank(message = "Password can not be empty!")
    private String password;

    @NotBlank(message = "Email can not be empty!")
    @Email(message = "Please provide a valid email address.")
    private String userEmail;

    @NotNull(message = "Please select a user type.")
    private BusinessUsersCategory userType;
}
