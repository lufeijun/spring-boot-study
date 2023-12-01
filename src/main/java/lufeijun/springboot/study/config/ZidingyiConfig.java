package lufeijun.springboot.study.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * 解析固定字段
 */
@Configuration
@Data
public class ZidingyiConfig {

  @Value("${lufeijun.name}")
  private String name;

  @Value("${lufeijun.email}")
  private String email;


  @Value("${lufeijun.type}")
  private String type;

}
