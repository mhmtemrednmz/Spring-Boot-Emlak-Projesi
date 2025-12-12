package com.emrednmz.service.impl;

import com.emrednmz.dto.response.UserResponse;
import com.emrednmz.exception.BaseException;
import com.emrednmz.exception.ErrorMesaage;
import com.emrednmz.exception.MessageType;
import com.emrednmz.model.User;
import com.emrednmz.repository.UserRepository;
import com.emrednmz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse getUserById(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isPresent()) {
            UserResponse userResponse = new UserResponse();
            userResponse.setCreateTime(optUser.get().getCreateTime());
            userResponse.setId(optUser.get().getId());
            userResponse.setEmail(optUser.get().getEmail());
            userResponse.setFirstName(optUser.get().getFirstName());
            userResponse.setLastName(optUser.get().getLastName());
            userResponse.setTelephone(optUser.get().getTelephone());
            userResponse.setDateOfBirth(optUser.get().getDateOfBirth());
            return userResponse;
        }
        throw new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_USER, id.toString()));
    }
}
