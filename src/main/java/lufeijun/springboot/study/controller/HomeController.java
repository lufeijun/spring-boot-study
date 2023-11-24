package lufeijun.springboot.study.controller;

import lufeijun.springboot.study.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
