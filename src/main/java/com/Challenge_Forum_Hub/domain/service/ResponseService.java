package com.Challenge_Forum_Hub.domain.service;

import com.Challenge_Forum_Hub.api.models.ResponseDto;
import com.Challenge_Forum_Hub.domain.models.Response;
import com.Challenge_Forum_Hub.domain.models.User;
import com.Challenge_Forum_Hub.domain.repository.ResponseRepository;
import com.Challenge_Forum_Hub.domain.repository.TopicRepository;
import com.Challenge_Forum_Hub.domain.repository.UserRepository;
import com.Challenge_Forum_Hub.infra.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    public Response createResponse(ResponseDto responsedto)
    {
        if(!userRepository.existsById(responsedto.authorId()))
        {
            throw new DomainException("User not found");
        }
        if(!topicRepository.existsById(responsedto.topicId()))
        {
            throw new RuntimeException("Topic not found");
        }
        var user = userRepository.getReferenceById(responsedto.authorId());
        var topic = topicRepository.getReferenceById(responsedto.topicId());

        Response response = Response.createResponse(responsedto, user, topic);
        return responseRepository.save(response);
    }

    public Response getById(UUID id) {
        return responseRepository.findById(id)
                .orElseThrow(() -> new DomainException("Response not found"));
    }

}
