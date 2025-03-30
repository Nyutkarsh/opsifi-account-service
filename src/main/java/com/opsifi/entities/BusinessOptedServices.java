package com.opsifi.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "businessoptedservices")
public class BusinessOptedServices implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private OpsifiServices service;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Column(columnDefinition = "JSON")
    private String globalConfig;

    private String accessToken;
    private boolean isActive = true;
    private LocalDateTime assignedDate = LocalDateTime.now();

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LocalDateTime getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDateTime assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getGlobalConfig() {
        return globalConfig;
    }

    public void setGlobalConfig(String globalConfig) {
        this.globalConfig = globalConfig;
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

    public OpsifiServices getService() {
        return service;
    }

    public void setService(OpsifiServices service) {
        this.service = service;
    }
}