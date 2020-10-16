package cn.com.yhb.service.impl;

import cn.com.yhb.ds1.mapper.TestUserMapper;
import cn.com.yhb.ds2.mapper.Test1User2Mapper;
import cn.com.yhb.ds3.mapper.Test3User3Mapper;
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
    Test1User2Mapper userMapper2;

    @Autowired
    Test3User3Mapper userMapper3;

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

    @Override
    public boolean pushData1() {
        boolean result = false;
        List<User> users = userMapper1.findAll();
        if (users.size() > 0) {
            for (User user : users) {
                if (null != userMapper3.queryById(user.getId())) continue;
                Integer integer = userMapper3.add(user);
                if (integer == 1) {
                    result = true;
                }
            }
        }
        return result;
    }
}
