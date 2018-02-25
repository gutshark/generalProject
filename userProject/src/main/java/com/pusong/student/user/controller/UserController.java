package com.pusong.student.user.controller;

import com.pusong.framework.annotation.LogAnnotation;
import com.pusong.student.user.service.UserService;
import com.pusong.student.user.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.StringValueExp;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @LogAnnotation(code = "select all users")
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(
                userService.getAll(),
                HttpStatus.OK);
    }

    @LogAnnotation(code = "select user")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
    }

    @GetMapping("/error")
    public ResponseEntity<?> error() throws Exception {
        throw new Exception("ERROR!!!");
    }

    @PostMapping("/wallets")
    public ResponseEntity<?> makeWallet() throws Exception {
        System.out.println("wallet service hashcode: " + String.valueOf(walletService.hashCode()));
        System.out.println("current thread hashcode: " + Thread.currentThread().hashCode());

        walletService.makeUserWallet();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
