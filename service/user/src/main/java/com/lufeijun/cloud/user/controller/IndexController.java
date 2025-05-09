package com.lufeijun.cloud.user.controller;

import com.lufeijun.cloud.common.reponse.ApiTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/info")
    public ApiTResponse<String> info(){
        ApiTResponse<String> response = new ApiTResponse<String>();
        response.setValues("user success...." + serverPort);
        return response;
    }
}
