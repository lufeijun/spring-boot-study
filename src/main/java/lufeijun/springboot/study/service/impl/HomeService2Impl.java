package lufeijun.springboot.study.service.impl;

import lufeijun.springboot.study.service.HomeService;
import org.springframework.stereotype.Service;

@Service
public class HomeService2Impl extends HomeServiceImpl {

  public String Name;

  @Override
  public String sayHello() {
    return "HomeServiceImpl2 hello world";
  }

//  @Override
//  public Integer error() {
//    return 2;
//  }
}
