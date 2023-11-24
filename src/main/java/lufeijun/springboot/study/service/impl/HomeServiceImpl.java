package lufeijun.springboot.study.service.impl;

import lufeijun.springboot.study.service.HomeService;
import org.springframework.stereotype.Service;

//@Service
public class HomeServiceImpl implements HomeService {
  @Override
  public String sayHello() {
    return "HomeServiceImpl hello world";
  }

  @Override
  public Integer error() {
    return 1;
  }
}
