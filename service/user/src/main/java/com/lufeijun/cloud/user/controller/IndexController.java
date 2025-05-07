package com.lufeijun.cloud.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class IndexController {

    @GetMapping("/info")
    public String info(){
        return "user success....";
    }
}
