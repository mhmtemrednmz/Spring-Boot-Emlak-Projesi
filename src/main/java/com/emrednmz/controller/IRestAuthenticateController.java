package com.emrednmz.controller;

import com.emrednmz.dto.request.AuthRequest;
import com.emrednmz.dto.request.RefreshTokenRequest;
import com.emrednmz.dto.request.UserRequest;
import com.emrednmz.dto.response.AuthResponse;
import com.emrednmz.dto.response.UserResponse;

public interface IRestAuthenticateController {
    RootEntity<UserResponse> register(UserRequest userRequest);
    RootEntity<AuthResponse> authenticate(AuthRequest authRequest);
    RootEntity<AuthResponse> refreshToken(RefreshTokenRequest refreshTokenRequest);
 }
