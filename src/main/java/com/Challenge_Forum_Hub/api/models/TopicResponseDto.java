package com.Challenge_Forum_Hub.api.models;

import com.Challenge_Forum_Hub.domain.models.Topic;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record TopicResponseDto(UUID id,
                               String title,
                               String message,
                               OffsetDateTime dataCreated,
                               String status,
                               String authorName,
                               String courseName,
                               List<ResponseDto> responses
                               ){
    public TopicResponseDto(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getDataCreated(),
                topic.getStatus(),
                topic.getAuthor() != null ? topic.getAuthor().getName() : null,
                topic.getCourse() != null ? topic.getCourse().getName() : null,
                topic.getResponses() != null ? topic.getResponses().stream()
                        .map(ResponseDto::new)
                        .toList() : List.of()
        );
    }
}
