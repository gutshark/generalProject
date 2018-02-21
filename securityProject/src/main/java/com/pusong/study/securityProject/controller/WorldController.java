package com.pusong.study.securityProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/worlds")
public class WorldController {
    @GetMapping
    public String hello(Principal principal) {
        return "hello world.";
    }
}
