package lufeijun.springboot.study.controller;

import lufeijun.springboot.study.common.time.MyTime;
import lufeijun.springboot.study.service.QmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 切面
 */
@RestController
@RequestMapping("/qm")
public class QmController {

  @Autowired
  private QmService qmService;

  @Autowired
  private MyTime myTime;

  @GetMapping("/index")
  public String sayhello() {
    System.out.println("请求时间start：" + myTime.getCurrentDatetime());
//    qmService.sayhello();

    qmService.sayhello2();
    System.out.println("请求时间end：" + myTime.getCurrentDatetime());
    return  "ok";
  }
}
