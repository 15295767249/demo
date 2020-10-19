package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.t_ICItemQuality;

public interface t_ICItemQualityMapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemQuality record);

    int insertSelective(t_ICItemQuality record);

    t_ICItemQuality selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemQuality record);

    int updateByPrimaryKey(t_ICItemQuality record);
}