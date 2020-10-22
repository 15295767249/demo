package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_Item;
import org.springframework.stereotype.Component;

@Component
public interface T_Item3Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_Item record);

    int insertSelective(t_Item record);

    t_Item selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_Item record);

    int updateByPrimaryKeyWithBLOBs(t_Item record);

    int updateByPrimaryKey(t_Item record);
}