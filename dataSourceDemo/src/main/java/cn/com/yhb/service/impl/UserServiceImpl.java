package cn.com.yhb.service.impl;

import cn.com.yhb.ds1.mapper.TestUserMapper;
import cn.com.yhb.ds2.mapper.Test1UserMapper;
import cn.com.yhb.model.User;
import cn.com.yhb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TestUserMapper userMapper1;

    @Autowired
    Test1UserMapper userMapper2;

    @Override
    public boolean pushData() {
        boolean result = false;
        List<User> users = userMapper1.findAll();
        if (users.size() > 0) {
            for (User user : users) {
                if (null != userMapper2.queryById(user.getId())) continue;
                Integer integer = userMapper2.add(user);
                if (integer == 1) {
                    result = true;
                }
            }
        }
        return result;
    }
}
