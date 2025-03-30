package com.opsifi.repository;

import com.opsifi.entities.BusinessInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessInvoiceRepository extends JpaRepository<BusinessInvoice, Long> {
}
