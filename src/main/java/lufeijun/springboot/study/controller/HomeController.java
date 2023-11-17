package lufeijun.springboot.study.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HomeController {

  @GetMapping("/")
  public Map<String,String> home() {
    Map<String,String> map = new HashMap<String,String>();
    map.put("status","0");
    map.put("message","ok");
    return map;
  }

  @RequestMapping(value = "/post", method = {RequestMethod.POST})
  public void testPost(@RequestParam("pageNum") String param) {
    System.out.println("POST请求"+param);
  }


}
