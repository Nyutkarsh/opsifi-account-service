package com.opsifi.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "OpsifiServices")
public class OpsifiServices implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false, unique = true)
    private UUID serviceUniqueId = UUID.randomUUID();

    @Column(columnDefinition = "JSON")
    private String serviceGlobalConfigTemplate;

    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updatedDate = LocalDateTime.now();

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceGlobalConfigTemplate() {
        return serviceGlobalConfigTemplate;
    }

    public void setServiceGlobalConfigTemplate(String serviceGlobalConfigTemplate) {
        this.serviceGlobalConfigTemplate = serviceGlobalConfigTemplate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public UUID getServiceUniqueId() {
        return serviceUniqueId;
    }

    public void setServiceUniqueId(UUID serviceUniqueId) {
        this.serviceUniqueId = serviceUniqueId;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
