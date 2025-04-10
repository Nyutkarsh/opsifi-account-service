package com.opsifi.repository;

import com.opsifi.entities.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long> {
}
