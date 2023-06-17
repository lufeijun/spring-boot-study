package lufeijun.study.springbootdemo.controller;

import lufeijun.study.springbootdemo.mapper.UserMapper;
import lufeijun.study.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mysql")
public class MysqlController {

	@Autowired
	UserMapper userMapper;

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") Long id) {

		User user = userMapper.getUserById(id);

		return user;
	}

}
