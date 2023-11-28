package lufeijun.springboot.study.config;

import lufeijun.springboot.study.common.time.MyTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  public MyTime myTimeBean() {
    return new MyTime();
  }
}
