package com.Challenge_Forum_Hub.api.models;

import com.Challenge_Forum_Hub.domain.models.Response;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ResponseDto(@NotNull String message, @NotBlank UUID topicId, @NotBlank UUID authorId, boolean solution){

    public ResponseDto(Response response) {
        this(response.getMessage(), response.getTopic().getId(),response.getAuthor().getId(), response.getSolution());
    }
}
