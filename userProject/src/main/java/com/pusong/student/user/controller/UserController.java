package com.pusong.student.user.controller;

import com.pusong.framework.annotation.LogAnnotation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @LogAnnotation(code = "select user")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        return new ResponseEntity<>("abc", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> error() throws Exception {
        throw new Exception("ERROR!!!");
    }
}
