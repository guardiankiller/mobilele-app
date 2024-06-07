package com.softuni.mobilele.service.impl;

import com.softuni.mobilele.model.UserLoginDTO;
import com.softuni.mobilele.model.UserRegistrationDTO;
import com.softuni.mobilele.model.entity.UserEntity;
import com.softuni.mobilele.repository.UserRepository;
import com.softuni.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistration) {
        // TODO:
        userRepository.save(map(userRegistration));
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {

        //todo

        return false;
    }

    public UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        UserEntity mappedEntity = modelMapper.map(userRegistrationDTO, UserEntity.class);

        mappedEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

        return mappedEntity;
    }

//    public static UserEntity entity(UserRegistrationDTO userRegistration) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setFirstName(userRegistration.getFirstName());
//        userEntity.setLastName(userRegistration.getLastName());
//        userEntity.setPassword(userRegistration.getPassword());
//        userEntity.setEmail(userRegistration.getEmail());
//        return userEntity;
//    }
}
