package lufeijun.springboot.study.service.impl;

import lufeijun.springboot.study.service.QmService;
import org.springframework.stereotype.Service;

@Service
public class QmServiceImpl implements QmService {

  @Override
  public void sayhello2() {
    System.out.println("QmServiceImpl hello v2");
  }

  @Override
  public void sayhello() {
    System.out.println("QmServiceImpl hello");
  }
}
