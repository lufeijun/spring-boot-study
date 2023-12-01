package lufeijun.springboot.study.controller;

import lufeijun.springboot.study.config.ZidingyiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/config")
public class ConfigController {

  @Autowired
  private ZidingyiConfig zidingyiConfig;

  @Value("${lufeijun.type}")
  private String type;

  @Autowired
  private Environment environment;

  @GetMapping("/index")
  public String index() {
    return  type;
  }


  @GetMapping("/zidingyi")
  public String zidingyi() {
    return  zidingyiConfig.toString();
  }

  @GetMapping("/env")
  public String env() {
    return environment.getProperty("lufeijun.type");
  }

}
