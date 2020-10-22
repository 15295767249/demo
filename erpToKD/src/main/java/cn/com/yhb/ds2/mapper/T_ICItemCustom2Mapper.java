package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.t_ICItemCustom;
import org.springframework.stereotype.Component;

@Component
public interface T_ICItemCustom2Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemCustom record);

    int insertSelective(t_ICItemCustom record);

    t_ICItemCustom selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemCustom record);

    int updateByPrimaryKey(t_ICItemCustom record);
}