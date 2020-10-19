package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_ICItemCustom;

public interface t_ICItemCustomMapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemCustom record);

    int insertSelective(t_ICItemCustom record);

    t_ICItemCustom selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemCustom record);

    int updateByPrimaryKey(t_ICItemCustom record);
}