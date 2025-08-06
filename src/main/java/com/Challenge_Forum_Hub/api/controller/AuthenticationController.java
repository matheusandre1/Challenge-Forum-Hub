package com.Challenge_Forum_Hub.api.controller;

import com.Challenge_Forum_Hub.api.models.DataRequestLogin;
import com.Challenge_Forum_Hub.api.models.DataTokenDto;
import com.Challenge_Forum_Hub.domain.models.User;
import com.Challenge_Forum_Hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationService;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataRequestLogin dataRequestLogin) {

            var authenticationtoken = new UsernamePasswordAuthenticationToken(dataRequestLogin.email(),dataRequestLogin.password());

            var authentication = authenticationService.authenticate(authenticationtoken);

            var token = tokenService.generateToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(new DataTokenDto(token));
    }


}
