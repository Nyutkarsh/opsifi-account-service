package com.opsifi.model;

import com.opsifi.enums.BusinessCategory;
import com.opsifi.enums.BusinessUsersCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnboardingRequestModel {

    @NotBlank
    private String businessName;

    private String businessAddress;
    @NotBlank
    private BusinessCategory businessType;
    @NotBlank
    private String businessSubType;
    @NotBlank
    private String businessCountry;
    @NotBlank
    private String adminName;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private BusinessUsersCategory userType;
}
