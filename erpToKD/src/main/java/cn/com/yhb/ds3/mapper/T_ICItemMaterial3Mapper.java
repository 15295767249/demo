package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_ICItemMaterial;
import org.springframework.stereotype.Component;

@Component
public interface T_ICItemMaterial3Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemMaterial record);

    int insertSelective(t_ICItemMaterial record);

    t_ICItemMaterial selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemMaterial record);

    int updateByPrimaryKey(t_ICItemMaterial record);
}