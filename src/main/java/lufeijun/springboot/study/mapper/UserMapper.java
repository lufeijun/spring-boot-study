package lufeijun.springboot.study.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lufeijun.springboot.study.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("SELECT u.id AS user_id, u.name AS user_name, u.age AS user_age, " +
//        "o.id AS order_id, o.order_no AS order_no, o.amount AS order_amount " +
//        "FROM user u LEFT JOIN orders o ON u.id = o.user_id " +
//        "WHERE u.id = #{userId}")
    @Select("SELECT * " +
        "FROM user " +
        "WHERE id = #{userId}")
    @Results(id = "UserWithOrdersResultMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "orders", column = "id", javaType = List.class,
            many = @Many(select = "lufeijun.springboot.study.mapper.OrderMapper.selectByUserId"))
    })
    User selectUserWithOrders(@Param("userId") int userId);


    // 使用 wrapper
    @Select("SELECT * " +
        "FROM user " +
        "${ew.customSqlSegment}")
    @ResultMap("UserWithOrdersResultMap")
    List<User> selectUserWithOrdersWapper(@Param("ew") Wrapper<User> wrapper);
}
