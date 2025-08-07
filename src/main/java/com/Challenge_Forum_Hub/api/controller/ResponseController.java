package com.Challenge_Forum_Hub.api.controller;

import com.Challenge_Forum_Hub.api.models.ResponseDto;
import com.Challenge_Forum_Hub.domain.repository.ResponseRepository;
import com.Challenge_Forum_Hub.domain.service.ResponseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/respostas")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class ResponseController {


    private final ResponseService responseService;
    private final ResponseRepository responseRepository;


    @PostMapping
    @Transactional
    public ResponseEntity createResponse(@RequestBody @Valid ResponseDto responseDto, UriComponentsBuilder uriBuilder)
    {
        var response = responseService.createResponse(responseDto);
        var uri = uriBuilder.path("/api/v1/responses/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity getResponseById(@PathVariable UUID id) {
        var response = responseService.getById(id);
        return ResponseEntity.ok(response);
    }

}
