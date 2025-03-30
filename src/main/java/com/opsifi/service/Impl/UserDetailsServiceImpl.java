package com.opsifi.service.Impl;

import com.opsifi.entities.BusinessUsers;
import com.opsifi.repository.BusinessUsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final BusinessUsersRepository businessUsersRepository;

    public UserDetailsServiceImpl(BusinessUsersRepository businessUsersRepository) {
        this.businessUsersRepository = businessUsersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<BusinessUsers> userOptional = businessUsersRepository.findByUserName(username);
        BusinessUsers user = userOptional.orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .roles(user.getUserType().name())
                .build();
    }
}
