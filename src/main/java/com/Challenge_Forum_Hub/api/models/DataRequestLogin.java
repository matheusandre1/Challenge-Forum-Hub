package com.Challenge_Forum_Hub.api.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataRequestLogin(@Email @NotBlank String email, @NotBlank String password) {}
