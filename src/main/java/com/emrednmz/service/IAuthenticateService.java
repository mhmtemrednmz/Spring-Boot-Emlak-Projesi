package com.emrednmz.service;

import com.emrednmz.dto.request.AuthRequest;
import com.emrednmz.dto.request.RefreshTokenRequest;
import com.emrednmz.dto.request.UserRequest;
import com.emrednmz.dto.response.AuthResponse;
import com.emrednmz.dto.response.UserResponse;

public interface IAuthenticateService {
    UserResponse register(UserRequest userRequest);
    AuthResponse authenticate(AuthRequest authRequest);
    AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

