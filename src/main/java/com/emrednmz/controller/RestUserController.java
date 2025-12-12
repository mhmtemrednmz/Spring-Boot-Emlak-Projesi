package com.emrednmz.controller;

import com.emrednmz.dto.response.UserResponse;

public interface RestUserController {
    RootEntity<UserResponse> getUserById(Long id);
}
