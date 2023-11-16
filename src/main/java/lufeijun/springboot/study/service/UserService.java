package lufeijun.springboot.study.service;


import lufeijun.springboot.study.entity.User;
import lufeijun.springboot.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
  @Autowired
  private UserMapper userMapper;

  public User getUserById(Long id) {
    return userMapper.getById(id);
  }

  public int save(User user) {
    return userMapper.save(user);
  }

  public int updateName(Long id, String name) {
    return userMapper.updateName(id,name);
  }


  public List<User> list(Map<String, Object> map) {
    return userMapper.list(map);
  }

}
