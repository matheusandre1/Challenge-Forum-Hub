package com.Challenge_Forum_Hub.api.controller;

import com.Challenge_Forum_Hub.api.models.UserDto;
import com.Challenge_Forum_Hub.domain.models.User;
import com.Challenge_Forum_Hub.domain.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid UserDto userDto)
    {
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    public User editUser(@PathVariable UUID id, @RequestBody @Valid UserDto userDto) {
        return userService.editUser(id, userDto);
    }



}
