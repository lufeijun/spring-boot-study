package lufeijun.study.springbootdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import lufeijun.study.springbootdemo.beans.config.Person;
import lufeijun.study.springbootdemo.beans.tool.JpHelper;
import lufeijun.study.springbootdemo.beans.tool.SpringContextUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return  "hello world, 打开新世界 java";
	}

	@RequestMapping("/a*/b?/{p1:[a-f]+}")
	public Map<String, String> hello(HttpServletRequest request , @PathVariable("p1") String path) {
		String uri = request.getRequestURI();

		Map<String,String> res = new HashMap<String,String>();
		res.put("path",path);
		res.put("uri", uri);

		return res;
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

	@RequestMapping("env")
	public Person env() {
		Person person = SpringContextUtil.getBean(Person.class);
		System.out.println( person );
		System.out.println( "憨直" );

		return person;
	}


	@RequestMapping("my-err")
	public String error1(HttpServletRequest request) {


		return "error";
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