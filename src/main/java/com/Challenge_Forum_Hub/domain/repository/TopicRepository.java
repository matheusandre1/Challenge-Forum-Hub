package com.Challenge_Forum_Hub.domain.repository;

import com.Challenge_Forum_Hub.domain.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {

    boolean existsByTitleOrMessage(String title, String message);
}
