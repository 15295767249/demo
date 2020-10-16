package cn.com.yhb.ds3.mapper;

import cn.com.yhb.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * mybatis mapper 接口定义（只要定义方法，无需实现）
 * @author yhb
 *
 */

@Component
public interface Test3User3Mapper {

    List<User> findAll();

    Integer add(User user);

    User queryById(Integer id);
}
