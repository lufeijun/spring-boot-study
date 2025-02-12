package lufeijun.springboot.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lufeijun.springboot.study.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("SELECT * FROM orders WHERE user_id = #{userId}")
    List<Order> selectByUserId(@Param("userId") int userId);
}
