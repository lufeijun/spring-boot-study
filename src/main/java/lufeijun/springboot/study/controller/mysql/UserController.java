package lufeijun.springboot.study.controller.mysql;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lufeijun.springboot.study.entity.User;
import lufeijun.springboot.study.mapper.UserMapper;
import lufeijun.springboot.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mysql/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("list")
    public List<User> getAll() {
        return  userService.list();
    }

    @GetMapping("list-v2")
    public Page<User> getAllV2(@RequestParam int pageNum , @RequestParam int pageSize) {
        return userService.getUserPage(pageNum,pageSize);
    }

    @GetMapping("detail")
    public  User detail(@RequestParam int id) {
        return userService.getById(id);
    }

    @GetMapping("detail/with/order")
    public  User detailWithOrder(@RequestParam int id) {
        return userMapper.selectUserWithOrders(id);
    }

    @GetMapping("detail/with/order/v2")
    public  List<User> detailWithOrderV2(@RequestParam int id) {
//        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).eq("u.id",id);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);

        return userMapper.selectUserWithOrdersWapper(wrapper);
    }


}
