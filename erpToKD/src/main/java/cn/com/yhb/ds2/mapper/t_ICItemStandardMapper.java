package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.t_ICItemStandard;

public interface t_ICItemStandardMapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemStandard record);

    int insertSelective(t_ICItemStandard record);

    t_ICItemStandard selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemStandard record);

    int updateByPrimaryKey(t_ICItemStandard record);
}