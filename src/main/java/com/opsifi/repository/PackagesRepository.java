package com.opsifi.repository;

import com.opsifi.entities.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackagesRepository extends JpaRepository<Packages, Long> {
}
