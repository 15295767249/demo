package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.t_ICItemStandard;
import org.springframework.stereotype.Component;

@Component
public interface T_ICItemStandard2Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemStandard record);

    int insertSelective(t_ICItemStandard record);

    t_ICItemStandard selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemStandard record);

    int updateByPrimaryKey(t_ICItemStandard record);
}