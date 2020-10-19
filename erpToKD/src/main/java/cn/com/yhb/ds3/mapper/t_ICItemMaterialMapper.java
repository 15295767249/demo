package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_ICItemMaterial;

public interface t_ICItemMaterialMapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemMaterial record);

    int insertSelective(t_ICItemMaterial record);

    t_ICItemMaterial selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemMaterial record);

    int updateByPrimaryKey(t_ICItemMaterial record);
}