package com.pusong.study.securityProject.service.impl;

import com.pusong.study.securityProject.entity.UserEntity;
import com.pusong.study.securityProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.getByLoginName(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("Username: " + username);
        }

        return new User(username, userEntity.getPassword(), new HashSet<SimpleGrantedAuthority>());
    }
}
