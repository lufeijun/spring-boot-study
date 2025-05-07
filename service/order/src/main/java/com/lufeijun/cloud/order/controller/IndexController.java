package com.lufeijun.cloud.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class IndexController {

    @GetMapping("/info")
    public String info(){
        return "order success....";
    }
}
