package com.Challenge_Forum_Hub.domain.service;

import com.Challenge_Forum_Hub.api.models.UserDto;
import com.Challenge_Forum_Hub.domain.models.User;
import com.Challenge_Forum_Hub.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(UserDto userDto)
    {
        var encoder = passwordEncoder.encode(userDto.password());
        userDto = new UserDto(userDto.name(), userDto.email(), encoder);

        var user = new User(userDto);

        return userRepository.saveAndFlush(user);
    }

    @Transactional
    public User editUser(UUID id, UserDto userDto) {
        var user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.edit(userDto);
        user.setPassword(passwordEncoder.encode(userDto.password()));
        return userRepository.saveAndFlush(user);
    }



}