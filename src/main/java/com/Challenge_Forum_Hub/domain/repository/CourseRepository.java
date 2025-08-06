package com.Challenge_Forum_Hub.domain.repository;

import com.Challenge_Forum_Hub.domain.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID>
{

}
