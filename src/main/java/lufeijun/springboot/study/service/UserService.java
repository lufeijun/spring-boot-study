package lufeijun.springboot.study.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import com.github.pagehelper.util.PageObjectUtil;
import lufeijun.springboot.study.common.page.PageResult;
import lufeijun.springboot.study.common.page.PageUtils;
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

  public PageResult pagelist(Integer pageNum,Integer pageSize) {
    // 1、从分页中拿数据
    PageHelper.startPage(pageNum,pageSize);
    List<User> userlist = userMapper.pagelist();
    System.out.println("数据库查询返回值"+ userlist.toString());

//    // 2、数据封装
//    if ( userlist.size() == 0 ) {
//      return  null;
//    }

    PageInfo<User> userPageInfo = new PageInfo<>(userlist);
    PageResult pageResult = PageUtils.getPageResult(userPageInfo);

    return pageResult;
  }


}
