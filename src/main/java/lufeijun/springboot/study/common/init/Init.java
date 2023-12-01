package lufeijun.springboot.study.common.init;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Init {

  @PostConstruct
  public void init() {
    System.out.println("init");
  }

}
