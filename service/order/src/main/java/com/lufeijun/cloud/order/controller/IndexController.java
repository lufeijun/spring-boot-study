package com.lufeijun.cloud.order.controller;

import com.lufeijun.cloud.common.reponse.ApiTResponse;
import com.lufeijun.cloud.order.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/order")
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("RestTemplateLoadBalanced")
    private RestTemplate restTemplateLoadBalanced;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/info")
    public ApiTResponse<String> info(){
        ApiTResponse<String> response = new ApiTResponse<String>();
        response.setValues("user success...." + serverPort);
        return response;
    }


    @GetMapping("/to/user")
    public String toUser(){
        // toUser1();
        // toUser2();
        // toUser3();
         toUser4();
        return "to user....";
    }

    private void toUser1(){
        System.out.println("toUser1");

        // 1、获取所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("service-user");

        System.out.println("服务个数：" + instances.size());

        // 2、随便拿一个
        ServiceInstance instance = instances.get( new Random().nextInt(instances.size()) );

        // 3、拼接url
        String url = instance.getUri() + "/api/user/info";

        System.out.println( url );

        ResponseEntity<ApiTResponse<String>> response = restTemplate.exchange(
                url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<ApiTResponse<String>>() {}
        );

        // 4、处理请求结果
        if ( response.getStatusCode().is2xxSuccessful() ) {
            System.out.println(response.getBody());
        } else {
            System.out.println("请求失败");
        }
    }

    private void toUser2(){
        System.out.println("toUser2");

        // 1、随机获取实例
        ServiceInstance choose = loadBalancerClient.choose("service-user");

        // 3、拼接url
        String url = choose.getUri() + "/api/user/info";

        ResponseEntity<ApiTResponse<String>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiTResponse<String>>() {}
        );

        // 4、处理请求结果
        if ( response.getStatusCode().is2xxSuccessful() ) {
            System.out.println(response.getBody());
        } else {
            System.out.println("请求失败");
        }
    }

    private void toUser3(){
        System.out.println("toUser3");

        // 3、拼接url
        String url =  "http://service-user/api/user/info";

        ResponseEntity<ApiTResponse<String>> response = restTemplateLoadBalanced.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiTResponse<String>>() {}
        );

        // 4、处理请求结果
        if ( response.getStatusCode().is2xxSuccessful() ) {
            System.out.println(response.getBody());
        } else {
            System.out.println("请求失败");
        }
    }


    private void toUser4(){
        System.out.println("toUser4");
        ApiTResponse<String> info = userFeign.info();
        System.out.println(info);
    }
}
