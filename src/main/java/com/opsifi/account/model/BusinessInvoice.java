package com.example.Onboarding.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "BusinessInvoice")
public class BusinessInvoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Column(nullable = false)
    private String invoicePath;

    @Column(columnDefinition = "JSON")
    private String invoiceJson;

    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceSubStatus subStatus;

}
enum InvoiceStatus {
    PAID, CANCELLED, PENDING;
}

enum InvoiceSubStatus {
    OVERDUE, ON_TIME;
}
