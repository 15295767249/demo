package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.t_Supplier;
import org.springframework.stereotype.Component;

@Component
public interface t_Supplier2Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_Supplier record);

    int insertSelective(t_Supplier record);

    t_Supplier selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_Supplier record);

    int updateByPrimaryKeyWithBLOBs(t_Supplier record);

    int updateByPrimaryKey(t_Supplier record);
}