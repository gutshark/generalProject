package com.pusong.student.user.service.impl;

import com.pusong.student.user.entity.UserEntity;
import com.pusong.student.user.repository.UserRepository;
import com.pusong.student.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
