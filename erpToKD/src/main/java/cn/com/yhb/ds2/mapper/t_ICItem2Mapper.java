package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.t_ICItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface t_ICItem2Mapper {
    int insert(t_ICItem record);

    int insertSelective(t_ICItem record);

    List<t_ICItem> findAll();
}