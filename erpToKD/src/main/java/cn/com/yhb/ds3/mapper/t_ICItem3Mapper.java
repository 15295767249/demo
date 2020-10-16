package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_ICItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface t_ICItem3Mapper {
    int insert(t_ICItem record);

    int insertSelective(t_ICItem record);

    List<t_ICItem> findAll();
}