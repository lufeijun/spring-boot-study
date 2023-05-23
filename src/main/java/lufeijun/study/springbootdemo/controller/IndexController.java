package lufeijun.study.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return  "hello world, 打开新世界";
	}

	@RequestMapping("/json")
	public Result json() {
		Result result = new Result(0,"success");

		return result;
	}
}


class Result {
	public int status;
	public String message;
	public String data;

	public Result(int status , String message) {
		this.status = status;
		this.message = message;
	}
}