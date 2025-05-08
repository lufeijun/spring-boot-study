package com.lufeijun.cloud.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/info")
    public String info(){
        return "user success...." + serverPort;
    }
}
