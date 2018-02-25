package com.pusong.student.user.service.impl;

import com.pusong.datasource.entity.UserEntity;
import com.pusong.framework.annotation.LogAnnotation;
import com.pusong.student.user.service.UserService;
import com.pusong.student.user.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private UserService userService;

    @LogAnnotation(code = "0201", description = "make wallet")
    @Override
    public void makeUserWallet() throws Exception {
        UserEntity userEntity = userService.register();
         userService.register("1");
         userService.register("1", "2");
        // todo: make user wallet
    }
}
