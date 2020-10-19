package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_ICItemBase;

public interface t_ICItemBaseMapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemBase record);

    int insertSelective(t_ICItemBase record);

    t_ICItemBase selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemBase record);

    int updateByPrimaryKey(t_ICItemBase record);
}