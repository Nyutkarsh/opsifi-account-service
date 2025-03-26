package com.opsifi.entities;

import com.opsifi.enums.BusinessCategory;
import com.opsifi.enums.TaxType;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Business")
public class Business implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false, unique = true)
    private UUID businessUniqueId = UUID.randomUUID();

    @Column(nullable = false)
    private String businessAddress;

    private LocalDateTime businessCreationDate = LocalDateTime.now();
    private LocalDateTime businessUpdationDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BusinessCategory businessType;

    @Column(nullable = false)
    private String businessSubType;

    @Column
    private String taxIdentificationNumber;

    @Enumerated(EnumType.STRING)
    @Column
    private TaxType taxType;

    @Column(nullable = false)
    private String businessCountry;

    private boolean isActive = true;

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public LocalDateTime getBusinessCreationDate() {
        return businessCreationDate;
    }

    public void setBusinessCreationDate(LocalDateTime businessCreationDate) {
        this.businessCreationDate = businessCreationDate;
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

    public UUID getBusinessUniqueId() {
        return businessUniqueId;
    }

    public void setBusinessUniqueId(UUID businessUniqueId) {
        this.businessUniqueId = businessUniqueId;
    }

    public LocalDateTime getBusinessUpdationDate() {
        return businessUpdationDate;
    }

    public void setBusinessUpdationDate(LocalDateTime businessUpdationDate) {
        this.businessUpdationDate = businessUpdationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
