package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_Organization;
import org.springframework.stereotype.Component;

@Component
public interface t_Organization3Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_Organization record);

    int insertSelective(t_Organization record);

    t_Organization selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_Organization record);

    int updateByPrimaryKeyWithBLOBs(t_Organization record);

    int updateByPrimaryKey(t_Organization record);
}