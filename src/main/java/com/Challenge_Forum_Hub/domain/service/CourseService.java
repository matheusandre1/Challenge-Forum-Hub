package com.Challenge_Forum_Hub.domain.service;

import com.Challenge_Forum_Hub.api.models.CourseDto;
import com.Challenge_Forum_Hub.domain.models.Course;
import com.Challenge_Forum_Hub.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course courseCreate(CourseDto courseDto)
    {
        Course course = Course.createCourse(courseDto.name(),courseDto.category());
        return courseRepository.save(course);
    }

    public Course getById(UUID id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
}
