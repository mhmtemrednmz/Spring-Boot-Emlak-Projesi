package com.emrednmz.service;

import com.emrednmz.dto.response.UserResponse;

public interface IUserService {
    UserResponse getUserById(Long id);
}
