package lufeijun.springboot.study.controller;

import lufeijun.springboot.study.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


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

}
