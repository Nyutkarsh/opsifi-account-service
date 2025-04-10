package com.opsifi.model;

import com.opsifi.enums.BusinessCategory;

public class BusinessAuthModel {

    private String businessName;
    private String businessAddress;
    private BusinessCategory businessType;
    private String businessSubType;
    private String businessCountry;

    public BusinessAuthModel() {}

    public BusinessAuthModel(String businessName, String businessAddress, BusinessCategory businessType, String businessSubType, String businessCountry) {
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessType = businessType;
        this.businessSubType = businessSubType;
        this.businessCountry = businessCountry;
    }

    public String getBusinessCountry() {
        return businessCountry;
    }

    public void setBusinessCountry(String businessCountry) {
        this.businessCountry = businessCountry;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessSubType() {
        return businessSubType;
    }

    public void setBusinessSubType(String businessSubType) {
        this.businessSubType = businessSubType;
    }

    public BusinessCategory getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessCategory businessType) {
        this.businessType = businessType;
    }
}
