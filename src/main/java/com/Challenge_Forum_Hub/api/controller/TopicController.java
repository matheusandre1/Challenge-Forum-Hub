package com.Challenge_Forum_Hub.api.controller;

import com.Challenge_Forum_Hub.api.models.TopicDto;
import com.Challenge_Forum_Hub.api.models.TopicResponseDto;
import com.Challenge_Forum_Hub.domain.service.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TopicResponseDto> createTopic(@RequestBody @Valid TopicDto topicDto, UriComponentsBuilder uriBuilder)
    {
        var topic = topicService.createTopic(topicDto);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicResponseDto(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDto> getTopicById(@PathVariable UUID id)
    {
        var topic = topicService.getTopicById(id);
        return ResponseEntity.ok(new TopicResponseDto(topic));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicResponseDto> updateTopic(@PathVariable UUID id, @RequestBody @Valid TopicDto topicDto) {
        var updatedTopic = topicService.editTopic(id, topicDto);
        return ResponseEntity.ok(new TopicResponseDto(updatedTopic));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteTopic(@PathVariable UUID id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }



}
