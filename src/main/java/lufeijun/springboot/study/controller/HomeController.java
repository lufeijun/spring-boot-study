package lufeijun.springboot.study.controller;

import lufeijun.springboot.study.exception.MyError;
import lufeijun.springboot.study.exception.MyRuntimeException;
import lufeijun.springboot.study.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HomeController {

  @Autowired
  private HomeService homeService;

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
    Thread.sleep(1000 * 60);
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



}
