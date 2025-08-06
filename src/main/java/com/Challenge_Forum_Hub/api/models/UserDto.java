package com.Challenge_Forum_Hub.api.models;


import com.Challenge_Forum_Hub.domain.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(@NotBlank String name,
                      @NotBlank
                      @Email
                      String email,
                      @NotNull
                      String password
) {
    public UserDto(User user) {
        this(user.getName(), user.getEmail(), user.getPassword());
    }
}
