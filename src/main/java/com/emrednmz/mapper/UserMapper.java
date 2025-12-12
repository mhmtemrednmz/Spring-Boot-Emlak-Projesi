package com.emrednmz.mapper;

import com.emrednmz.dto.request.UserRequest;
import com.emrednmz.dto.response.UserResponse;
import com.emrednmz.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);
}
