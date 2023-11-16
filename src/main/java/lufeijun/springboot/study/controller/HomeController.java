package lufeijun.springboot.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
