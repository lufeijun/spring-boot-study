package lufeijun.springboot.study.controller;


import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/validated")
public class ValidationController {


  @PostMapping("/index")
  public String index(String name,@NotBlank(message = "email 不能为空") String email , Integer age) {

    System.out.println(name+"==="+email + "====" + age);
    return name+"==="+email + "====" + age;
  }

  private void test(@NotBlank String name , String email , Integer age) {
    System.out.println("ok");
    System.out.println(name+"==="+email + "====" + age);
  }

}
