package com.opsifi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnboardingResponseModel {
    private String message;
    private String status;
    private String statusCode;

}
