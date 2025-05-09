package com.lufeijun.cloud.order.feign;

import com.lufeijun.cloud.common.reponse.ApiTResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-user")
public interface UserFeign {

    @GetMapping("/api/user/info")
    public ApiTResponse<String> info();

    @GetMapping("/api/user/info")
    public ResponseEntity<ApiTResponse<String>> infoWithResponse();
}
