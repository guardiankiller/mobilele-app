package com.softuni.mobilele.service;

import com.softuni.mobilele.model.UserLoginDTO;
import com.softuni.mobilele.model.UserRegistrationDTO;
import com.softuni.mobilele.model.user.MobileleUserDetails;

import java.util.Optional;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    Optional<MobileleUserDetails> getCurrentUser();
}
