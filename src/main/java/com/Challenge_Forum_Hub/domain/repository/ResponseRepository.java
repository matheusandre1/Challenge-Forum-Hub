package com.Challenge_Forum_Hub.domain.repository;

import com.Challenge_Forum_Hub.domain.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResponseRepository extends JpaRepository<Response, UUID> {
}
