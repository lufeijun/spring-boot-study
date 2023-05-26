package lufeijun.study.springbootdemo.controller;

import lufeijun.study.springbootdemo.beans.tool.JpHelper;
import lufeijun.study.springbootdemo.beans.tool.SpringContextUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping("bean")
	public String bean() {
		String str;

		JpHelper jpHelper1 = SpringContextUtil.getBean(JpHelper.class);
		JpHelper jpHelper2 = (JpHelper) SpringContextUtil.getBean("jpHelper");

		System.out.println("设置之前：" + jpHelper2.name);

		jpHelper1.setName("test1");

		System.out.println("设置之前：" + jpHelper2.name);

		str = "两个类是否相等==" + jpHelper1.equals(jpHelper2);

		return str;
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