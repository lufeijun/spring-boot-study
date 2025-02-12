package lufeijun.springboot.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("user")
@Data
public class User {
    @TableId(type = IdType.AUTO) // 指定主键和自增策略
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String email;
    private String wechatName;
    private String created;
    private String updated;

    @TableField(exist = false)
    private List<Order> orders; // 一对过关联
}
