package com.opsifi.repository;

import com.opsifi.entities.BusinessOptedServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessOptedServicesRepository extends JpaRepository<BusinessOptedServices, Long> {
}