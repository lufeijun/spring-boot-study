package lufeijun.springboot.study.controller;

import lufeijun.springboot.study.entity.User;
import lufeijun.springboot.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    user.setName("修改了");
    return user;
  }

  @GetMapping("save")
  public Integer save() {
    User user = new User();
    user.setName("测试");
    user.setAge(11);
    user.setPassword("密码");
    user.setEmail("aaa@xxx.com");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String str = formatter.format(new Date());
    user.setCreated( str );
    user.setUpdated( str );

    System.out.println(user);

    return  userService.save(user);
  }

  @GetMapping("update")
  public int upadte() {
    return userService.updateName(1L,"名称修改");
  }

  @GetMapping("list")
  public List<User> list(){
    Integer page = 1;
    Integer pageSize = 3;


    HashMap<String, Object> search = new HashMap<>();
    search.put("pageSize",pageSize);
    search.put("startPos", (page - 1) * 3);
    search.put("name", "测试17");
//    search.put("age",1);

    return userService.list(search);
  }


}