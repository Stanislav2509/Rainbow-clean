package com.example.Rainbow.clean.service;

import com.example.Rainbow.clean.model.dto.UserRegisterBindingModel;

public interface UserService {
//    void login(UserLoginBindingModel userLoginBindingModel);
    boolean register(UserRegisterBindingModel userRegisterBindingModel);
}
