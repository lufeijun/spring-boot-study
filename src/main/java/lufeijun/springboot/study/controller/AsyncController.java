package lufeijun.springboot.study.controller;

import lufeijun.springboot.study.common.time.MyTime;
import lufeijun.springboot.study.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

  @Autowired
  private AsyncService asyncService;

  @Autowired
  private MyTime myTime;

  @GetMapping("/index")
  public String index() {
    asyncService.index();
    return  "async index controller" + myTime.getCurrentDatetime();
  }

  @GetMapping("/custom")
  public String custom() {
    for (int i=0 ; i < 3 ; i++) {
      asyncService.custom(i);
    }
    return  "async custom controller" + myTime.getCurrentDatetime();
  }

  @GetMapping("/autowire")
  public String autowire() {
    asyncService.autowired();
    return  "async autowire controller" + myTime.getCurrentDatetime();
  }



}
