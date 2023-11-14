package com.example.Rainbow.clean.service.impl;

import com.example.Rainbow.clean.model.dto.UserRegisterBindingModel;
import com.example.Rainbow.clean.model.entity.UserEntity;
import com.example.Rainbow.clean.repo.UserRepository;
import com.example.Rainbow.clean.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if(!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            return false;
        }

        boolean existsByEmail = userRepository.existsByEmail(userRegisterBindingModel.getEmail());

        if(existsByEmail){
            return false;
        }

        UserEntity user = new UserEntity();
        user.setFirstName(userRegisterBindingModel.getFirstName());
        user.setLastName(userRegisterBindingModel.getLastName());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        user.setGsm(userRegisterBindingModel.getGsm());

        userRepository.save(user);

        return true;
    }
}
