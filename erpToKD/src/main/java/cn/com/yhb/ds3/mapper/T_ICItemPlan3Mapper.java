package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_ICItemPlan;
import org.springframework.stereotype.Component;

@Component
public interface T_ICItemPlan3Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemPlan record);

    int insertSelective(t_ICItemPlan record);

    t_ICItemPlan selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemPlan record);

    int updateByPrimaryKey(t_ICItemPlan record);
}