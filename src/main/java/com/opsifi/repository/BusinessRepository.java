package com.opsifi.repository;

import com.opsifi.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    Optional<Business> findByBusinessUniqueId(UUID businessUniqueId);
}

