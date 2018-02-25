package com.pusong.student.user.service;

import com.pusong.datasource.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity get(String id);

    List<UserEntity> getAll();

    UserEntity register() throws Exception;
    UserEntity register(String id) throws Exception;
    UserEntity register(String id, String abc) throws Exception;
}
