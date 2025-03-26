package com.example.Onboarding.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BusinessType")
public class BusinessType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private BusinessCategory label;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BusinessCategory getLabel() { return label; }
    public void setLabel(BusinessCategory label) { this.label = label; }
}

enum BusinessCategory {
    RETAIL_CHAIN, SCHOOL, INSTITUTE, MANUFACTURING_FACILITY;
}
