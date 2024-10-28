package com.tracker.croquy.v1.controllers;

import com.tracker.croquy.v1.dto.authentication.AuthenticationRequest;
import com.tracker.croquy.v1.dto.authentication.AuthenticationResponse;
import com.tracker.croquy.v1.dto.authentication.RefreshTokenRequest;
import com.tracker.croquy.v1.services.AuthenticationService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping(path = "/login")
    public ResponseEntity<AuthenticationResponse> login(
            @Valid @RequestBody AuthenticationRequest request
    ) {
        AuthenticationResponse loginResponse = authenticationService.login(request);

        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

    @PostMapping(path = "/refresh")
    public ResponseEntity<AuthenticationResponse> refresh(
            @Valid @RequestBody RefreshTokenRequest request
    ) {
        AuthenticationResponse refreshResponse = authenticationService.refresh(request);

        return ResponseEntity.status(HttpStatus.OK).body(refreshResponse);
    }
}
