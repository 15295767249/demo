package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_ICItemCore;
import org.springframework.stereotype.Component;

@Component
public interface T_ICItemCore3Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemCore record);

    int insertSelective(t_ICItemCore record);

    t_ICItemCore selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemCore record);

    int updateByPrimaryKeyWithBLOBs(t_ICItemCore record);

    int updateByPrimaryKey(t_ICItemCore record);
}