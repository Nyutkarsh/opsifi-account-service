package com.opsifi.repository;

import com.opsifi.entities.OpsifiServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpsifiServicesRepository extends JpaRepository<OpsifiServices, Long> {
}
