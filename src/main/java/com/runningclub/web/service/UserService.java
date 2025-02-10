package com.runningclub.web.service;

import com.runningclub.web.dto.RegistrationDto;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
}
