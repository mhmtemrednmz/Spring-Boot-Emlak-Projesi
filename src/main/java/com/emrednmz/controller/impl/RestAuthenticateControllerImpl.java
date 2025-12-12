package com.emrednmz.controller.impl;

import com.emrednmz.controller.IRestAuthenticateController;
import com.emrednmz.controller.RestBaseController;
import com.emrednmz.controller.RootEntity;
import com.emrednmz.dto.request.AuthRequest;
import com.emrednmz.dto.request.RefreshTokenRequest;
import com.emrednmz.dto.request.UserRequest;
import com.emrednmz.dto.response.AuthResponse;
import com.emrednmz.dto.response.UserResponse;
import com.emrednmz.service.IAuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticateControllerImpl extends RestBaseController implements IRestAuthenticateController {
    @Autowired
    private IAuthenticateService authenticateService;

    @PostMapping("register")
    @Override
    public RootEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        return ok(authenticateService.register(userRequest));
    }

    @PostMapping("authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return ok(authenticateService.authenticate(authRequest));

    }
    @PostMapping("refresh_token")
    @Override
    public RootEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ok(authenticateService.refreshToken(refreshTokenRequest));
    }



}
