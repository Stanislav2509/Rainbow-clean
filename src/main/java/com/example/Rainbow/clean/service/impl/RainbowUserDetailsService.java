package com.example.Rainbow.clean.service.impl;


import com.example.Rainbow.clean.model.entity.UserEntity;
import com.example.Rainbow.clean.repo.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class RainbowUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public RainbowUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found!"));
    }

    private UserDetails map(UserEntity userEntity){
        UserDetails userDetails = User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of())
                .build();

        return userDetails;
    }
}
