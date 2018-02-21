package com.pusong.study.securityProject.service;

import com.pusong.study.securityProject.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity get(String id);

    List<UserEntity> getAll();

    UserEntity getByLoginName(String loginName);
}