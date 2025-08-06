package com.Challenge_Forum_Hub.api.models;

import jakarta.validation.constraints.NotNull;

public record CourseDto(@NotNull String name, @NotNull String category) {
}
