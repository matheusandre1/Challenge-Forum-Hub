package com.Challenge_Forum_Hub.domain.service;

import com.Challenge_Forum_Hub.api.models.TopicDto;
import com.Challenge_Forum_Hub.domain.models.Topic;
import com.Challenge_Forum_Hub.domain.repository.CourseRepository;
import com.Challenge_Forum_Hub.domain.repository.TopicRepository;
import com.Challenge_Forum_Hub.domain.repository.UserRepository;
import com.Challenge_Forum_Hub.infra.exception.DomainException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Transactional
    public Topic createTopic(TopicDto topicDto) {

        if(!userRepository.existsById(topicDto.userId()))
        {
            throw new DomainException("User not found");
        }
        if(!courseRepository.existsById(topicDto.courseId()))
        {
            throw new DomainException("Course not found");
        }

        boolean exists = topicRepository.existsByTitleOrMessage(topicDto.title(), topicDto.message());

        if (exists) {
            throw new DomainException("A topic with the same title or message already exists");
        }

        var user = userRepository.getReferenceById(topicDto.userId());
        var course = courseRepository.getReferenceById(topicDto.courseId());

        Topic topic = Topic.createTopic(topicDto, user, course);

        return topicRepository.save(topic);
    }

    @Transactional
    public Topic getTopicById(UUID id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new DomainException("Topic not found"));
    }

    @Transactional
    public Topic editTopic(UUID id, TopicDto topicDto) {

        if (topicDto.userId() != null && !userRepository.existsById(topicDto.userId()))
        {
            throw new DomainException("User not found");
        }
        if (topicDto.courseId() != null && !courseRepository.existsById(topicDto.courseId()))
        {
            throw new DomainException("Course not found");

        }

        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new DomainException("Topic not found"));

        topic.editTopic(topicDto);

        return topicRepository.save(topic);
    }

    @Transactional
    public void deleteTopic(UUID id)
    {
        if (!topicRepository.existsById(id)) {
            throw new DomainException("Topic not found");
        }
        topicRepository.deleteById(id);
    }
}
