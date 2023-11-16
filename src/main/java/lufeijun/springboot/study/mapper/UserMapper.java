package lufeijun.springboot.study.mapper;

import lufeijun.springboot.study.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
  User getById(Long id);
  int save(@Param("user") User user);

  int updateName(Long id, String name);

  List<User> list(Map<String, Object> map);
}
