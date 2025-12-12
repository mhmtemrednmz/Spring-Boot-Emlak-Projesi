package com.emrednmz.service.impl;

import com.emrednmz.dto.request.AuthRequest;
import com.emrednmz.dto.request.RefreshTokenRequest;
import com.emrednmz.dto.request.UserRequest;
import com.emrednmz.dto.response.AuthResponse;
import com.emrednmz.dto.response.UserResponse;
import com.emrednmz.exception.BaseException;
import com.emrednmz.exception.ErrorMesaage;
import com.emrednmz.exception.MessageType;
import com.emrednmz.jwt.JwtService;
import com.emrednmz.mapper.UserMapper;
import com.emrednmz.model.RefreshToken;
import com.emrednmz.model.User;
import com.emrednmz.repository.RefreshTokenRepository;
import com.emrednmz.repository.UserRepository;
import com.emrednmz.service.IAuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticateServiceImpl implements IAuthenticateService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Override
    public UserResponse register(UserRequest userRequest) {
        User savedUser = userRepository.save(createUser(userRequest));
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            Optional<User> optUser = userRepository.findByEmail(authRequest.getEmail());

            String accessToken = jwtService.generateToken(optUser.get());
            RefreshToken refreshToken = refreshTokenRepository.save(createRefreshToken(optUser.get()));

            return new AuthResponse(accessToken, refreshToken.getRefreshToken());
        } catch (Exception e) {
            throw new BaseException(new ErrorMesaage(MessageType.EMAIL_OR_PASSWORD_INCORRECT, e.getMessage()));
        }
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(refreshTokenRequest.getRefreshToken());
        if (optRefreshToken.isEmpty()) {
            throw new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_REFRESH_TOKEN, refreshTokenRequest.getRefreshToken()));
        }
        if (!isValidRefreshToken(optRefreshToken.get().getExpiredDate())){
            throw new BaseException(new ErrorMesaage(MessageType.TOKEN_IS_NOT_VALID, refreshTokenRequest.getRefreshToken()));
        }

        User user = optRefreshToken.get().getUser();
        String accessToken = jwtService.generateToken(user);
        RefreshToken refreshToken = refreshTokenRepository.save(createRefreshToken(user));

        return new AuthResponse(accessToken, refreshToken.getRefreshToken());
    }

    private User createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        user.setCreateTime(new Date());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return user;
    }
    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setCreateTime(new Date());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshToken;
    }
    private boolean isValidRefreshToken(Date expiredDate) {
        return new Date().after(expiredDate);
    }
}
