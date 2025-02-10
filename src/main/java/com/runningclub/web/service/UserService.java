package com.runningclub.web.service;

import com.runningclub.web.dto.RegistrationDto;
import com.runningclub.web.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findUserByUsername(String username);
    UserEntity findUserByEmail(String email);
}
