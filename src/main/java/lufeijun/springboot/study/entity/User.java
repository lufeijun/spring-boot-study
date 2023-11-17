package lufeijun.springboot.study.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
  private Long id;
  private String name;

  private String wechat_name;
  private Integer age;
  private String email;
  private String password;
  private String created;
  private String updated;
}
