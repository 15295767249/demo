package cn.com.yhb.ds2.mapper;

import cn.com.yhb.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * mybatis mapper 接口定义（只要定义方法，无需实现）
 * @author yhb
 *
 */

@Component
public interface Test1User2Mapper {

    List<User> findAll();

    Integer add(User user);

    User queryById(Integer id);
}
