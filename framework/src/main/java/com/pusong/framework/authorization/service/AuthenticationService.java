package com.pusong.framework.authorization.service;

import com.pusong.framework.authorization.AuthUserModel;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    AuthUserModel get(Authentication authentication);
}
