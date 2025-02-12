package lufeijun.springboot.study.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lufeijun.springboot.study.entity.User;

public interface UserService extends IService<User> {

    Page<User> getUserPage(int pageNum , int pageSize);
}
