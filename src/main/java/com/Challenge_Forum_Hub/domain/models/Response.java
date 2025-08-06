package com.Challenge_Forum_Hub.domain.models;


import com.Challenge_Forum_Hub.api.models.ResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Response {

    @Id
    private UUID id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    private OffsetDateTime dataCreated;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private Boolean solution;


    public static Response createResponse(ResponseDto responseDto, User author, Topic topic)
    {
        Response response = new Response();
        response.setId(UUID.randomUUID());
        response.setMessage(responseDto.message());
        response.setTopic(topic);
        response.setDataCreated(OffsetDateTime.now());
        response.setAuthor(author);
        response.setSolution(responseDto.solution());
        return response;
    }
}
