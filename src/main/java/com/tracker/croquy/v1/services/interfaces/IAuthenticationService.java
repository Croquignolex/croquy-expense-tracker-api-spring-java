package com.tracker.croquy.v1.services.interfaces;

import com.tracker.croquy.v1.dto.authentication.AuthenticationRequest;
import com.tracker.croquy.v1.dto.authentication.AuthenticationResponse;
import com.tracker.croquy.v1.dto.authentication.RefreshTokenRequest;

public interface IAuthenticationService {
    AuthenticationResponse login(AuthenticationRequest request);
    AuthenticationResponse refresh(RefreshTokenRequest request);
}
