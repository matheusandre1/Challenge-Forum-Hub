package com.Challenge_Forum_Hub.domain.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private UUID id;
    private String name;
    private String category;

    public Course(@NotNull UUID uuid) {
    }

    public static Course createCourse(String name, String category) {
        Course course = new Course();
        course.setId(UUID.randomUUID());
        course.setName(name);
        course.setCategory(category);
        return course;
    }

}
