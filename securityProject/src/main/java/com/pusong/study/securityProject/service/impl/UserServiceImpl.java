package com.pusong.study.securityProject.service.impl;

import com.pusong.study.securityProject.entity.UserEntity;
import com.pusong.study.securityProject.repository.UserRepository;
import com.pusong.study.securityProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
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

    @Override
    public UserEntity getByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName);
    }
}
