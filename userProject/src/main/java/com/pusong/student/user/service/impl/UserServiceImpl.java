package com.pusong.student.user.service.impl;

import com.pusong.datasource.entity.UserEntity;
import com.pusong.datasource.repository.secondary.UserRepository;
import com.pusong.framework.annotation.LogAnnotation;
import com.pusong.framework.authorization.AuthUserModel;
import com.pusong.framework.authorization.service.AuthenticationService;
import com.pusong.student.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService, AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity get(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @LogAnnotation(code = "0101", description = "register user")
    @Override
    public UserEntity register() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setMobile("12345678");
        userEntity.setUserName("old wang neanext door.");
        userEntity.setNickname("old wang");
//throw new Exception("register error");
        return userEntity;
    }

    @LogAnnotation(code = "0102", description = "register user")
    @Override
    public UserEntity register(String id) throws Exception {
        return null;
    }

    @LogAnnotation(code = "0103", description = "register user")
    @Override
    public UserEntity register(String id, String abc) throws Exception {
        throw new Exception("register id error");
    }

    @Override
    public AuthUserModel get(Authentication authentication) {
        AuthUserModel authUser = new AuthUserModel();
        authUser.setId("take the id from db");
        authUser.setMobile("13916718790");
        authUser.setUserName("YangZhenyu");
        authUser.setNickname("gutshark");
        return authUser;
    }
}
