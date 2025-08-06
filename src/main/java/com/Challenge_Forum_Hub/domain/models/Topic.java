package com.Challenge_Forum_Hub.domain.models;

import com.Challenge_Forum_Hub.api.models.TopicDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    private UUID id;
    @Column(unique=true)
    private String title;
    @Column(unique=true)
    private String message;
    private OffsetDateTime dataCreated;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Response> responses;

    public static Topic createTopic(TopicDto topicDto, User author, Course course) {
        Topic topic = new Topic();
        topic.setId(UUID.randomUUID());
        topic.setTitle(topicDto.title());
        topic.setMessage(topicDto.message());
        topic.setDataCreated(OffsetDateTime.now());
        topic.setStatus("OPEN");
        topic.setAuthor(author);
        topic.setCourse(course);
        return topic;
    }

    public void editTopic(TopicDto topicDto) {
        this.setTitle(topicDto.title());
        this.setMessage(topicDto.message());
        this.setStatus(topicDto.status());
        this.setAuthor(topicDto.userId() != null ? new User(topicDto.userId()) : null);
        this.setCourse(topicDto.courseId() != null ? new Course(topicDto.courseId()) : null);
        this.setDataCreated(OffsetDateTime.now());
    }

}
