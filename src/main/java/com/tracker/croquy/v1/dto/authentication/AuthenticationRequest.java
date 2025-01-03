package com.tracker.croquy.v1.dto.authentication;

import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationRequest {
    @NotEmpty(message = "Username field is required")
    private String username;

    @NotEmpty(message = "Password field is required")
    private String password;
}