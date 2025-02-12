package lufeijun.springboot.study.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("orders")
public class Order {
    private int id;
    private int userId;
    private String orderNo;
    private BigDecimal amount;
}
