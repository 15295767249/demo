package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.t_ICItemBase;
import org.springframework.stereotype.Component;

@Component
public interface t_ICItemBase2Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemBase record);

    int insertSelective(t_ICItemBase record);

    t_ICItemBase selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemBase record);

    int updateByPrimaryKey(t_ICItemBase record);
}