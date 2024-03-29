package lufeijun.springboot.study.controller;

import lufeijun.springboot.study.common.page.PageResult;
import lufeijun.springboot.study.entity.User;
import lufeijun.springboot.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
//    user.setName("修改了");
    return user;
  }

  @GetMapping("/entity/{id}")
  public ResponseEntity<User> getUserById2(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user);
  }


  @GetMapping("save")
  public Long save() {
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

    userService.save(user);

    return user.getId();
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
//    search.put("name", "测试17");
//    search.put("age",1);

    return userService.list(search);
  }

  @PostMapping("list2")
  public PageResult list2(@RequestBody Map<String,Object> map) {

    System.out.println(map.get("pageNum"));

    //起始索引:
    Integer pageNum = Integer.parseInt(map.get("pageNum").toString());
    if ( pageNum == 0 ) {
      pageNum = 1;
    }

    //查询的条数
    Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
    if ( pageSize == 0 ) {
      pageSize = 30;
    }

    return userService.pagelist(pageNum,pageSize);
  }

}
