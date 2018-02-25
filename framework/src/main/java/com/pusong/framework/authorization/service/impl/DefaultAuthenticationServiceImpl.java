package com.pusong.framework.authorization.service.impl;


import com.pusong.framework.authorization.AuthUserModel;
import com.pusong.framework.authorization.service.AuthenticationService;
import org.springframework.security.core.Authentication;

public class DefaultAuthenticationServiceImpl implements AuthenticationService {
    @Override
    public AuthUserModel get(Authentication authentication) {
        AuthUserModel authUser = new AuthUserModel();
        authUser.setId("default");
        authUser.setMobile("123456");
        authUser.setUserName("YangZhenyu");
        authUser.setNickname("gutshark");

        return authUser;
    }
}
