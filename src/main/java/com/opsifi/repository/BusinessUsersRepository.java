package com.opsifi.repository;

import com.opsifi.entities.BusinessUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessUsersRepository extends JpaRepository<BusinessUsers, Long> {
    Optional<BusinessUsers> findByUserName(String userName);
}
