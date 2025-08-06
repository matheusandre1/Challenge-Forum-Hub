package com.Challenge_Forum_Hub.api.models;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TopicDto(@NotNull String title, @NotNull String message,
                       String status, @NotNull UUID userId, @NotNull UUID courseId

                       ) {
}
