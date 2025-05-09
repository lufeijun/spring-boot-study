package com.lufeijun.cloud.order.feign;

import com.lufeijun.cloud.common.reponse.ApiTResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-user")
public interface UserFeign {

    @GetMapping("/api/user/info")
    public ApiTResponse<String> info();
}
