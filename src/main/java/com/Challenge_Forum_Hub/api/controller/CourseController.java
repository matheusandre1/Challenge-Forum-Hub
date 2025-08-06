package com.Challenge_Forum_Hub.api.controller;

import com.Challenge_Forum_Hub.api.models.CourseDto;
import com.Challenge_Forum_Hub.domain.service.CourseService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController
{
    private final CourseService courseService;


    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCourse(@RequestBody @Valid CourseDto courseDto)
    {
        var course = courseService.courseCreate(courseDto);
        return ResponseEntity.status(201).body(course);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity getCourseById(@PathVariable UUID id)
    {
        var course = courseService.getById(id);
        return ResponseEntity.ok(course);
    }

}
