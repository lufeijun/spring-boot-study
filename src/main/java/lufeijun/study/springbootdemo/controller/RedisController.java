package lufeijun.study.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/redis")
public class RedisController {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@RequestMapping(path = "index")
	public String index() {

		stringRedisTemplate.opsForValue().set("name","吉鹏");

		return "ok";
	}

	@RequestMapping("get")
	public String get() {
		String name = stringRedisTemplate.opsForValue().get("name");

		System.out.println(name);

		return name;
	}


}
