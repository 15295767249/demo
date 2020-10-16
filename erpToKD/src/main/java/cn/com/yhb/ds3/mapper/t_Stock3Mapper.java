package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_Stock;
import org.springframework.stereotype.Component;

@Component
public interface t_Stock3Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_Stock record);

    int insertSelective(t_Stock record);

    t_Stock selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_Stock record);

    int updateByPrimaryKeyWithBLOBs(t_Stock record);

    int updateByPrimaryKey(t_Stock record);
}