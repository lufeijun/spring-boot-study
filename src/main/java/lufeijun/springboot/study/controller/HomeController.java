package lufeijun.springboot.study.controller;

import lufeijun.springboot.study.common.email.MyEmail;
import lufeijun.springboot.study.exception.MyRuntimeException;
import lufeijun.springboot.study.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HomeController {

  @Autowired
  private HomeService homeService;

  @Autowired
  private MyEmail myEmail;

  @GetMapping("/")
  public String home() {

    var s = homeService.sayHello();
    return s;
  }

  @RequestMapping(value = "/post", method = {RequestMethod.POST})
  public void testPost(@RequestParam("pageNum") String param) {
    System.out.println("POST请求"+param);
  }


  @GetMapping("/get")
  public String index() {
    System.out.println(homeService);
    return  HomeService.name;
  }

  @GetMapping("/set")
  public String index2() {
//    HomeService.name = "dasdsad";
    return  HomeService.name;
  }


  @GetMapping("/sleep")
  public String sleep() throws Exception{
    Thread.sleep(1000 * 50);
    return "ok";
  }

  @GetMapping("/error1")
  public String error() {
    throw new MyRuntimeException("业务报错信息");

//    return "";
  }

  @GetMapping("/exception")
  public String exception() {
    int i = 9/0;
    return  "exception";
  }


  // 发送邮件
  @GetMapping("/mail")
  public String mail() {
    myEmail.sendSimpleMail(
      "lufeijun_1234@126.com",
      "测试",
      "具体内容"
    );
    return "mail";
  }

}
