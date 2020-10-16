package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.t_ItemClass;
import org.springframework.stereotype.Component;

@Component
public interface t_ItemClass2Mapper {
    int deleteByPrimaryKey(Integer fitemclassid);

    int insert(t_ItemClass record);

    int insertSelective(t_ItemClass record);

    t_ItemClass selectByPrimaryKey(Integer fitemclassid);

    int updateByPrimaryKeySelective(t_ItemClass record);

    int updateByPrimaryKeyWithBLOBs(t_ItemClass record);

    int updateByPrimaryKey(t_ItemClass record);
}