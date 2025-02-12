package lufeijun.springboot.study.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lufeijun.springboot.study.entity.User;
import lufeijun.springboot.study.mapper.UserMapper;
import lufeijun.springboot.study.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Page<User> getUserPage(int pageNum , int pageSize) {
        Page<User> page = new Page<>(pageNum,pageSize);
        return  baseMapper.selectPage(page,null);
    }
}
