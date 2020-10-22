package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.t_ICItemDesign;
import org.springframework.stereotype.Component;

@Component
public interface T_ICItemDesign2Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemDesign record);

    int insertSelective(t_ICItemDesign record);

    t_ICItemDesign selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemDesign record);

    int updateByPrimaryKey(t_ICItemDesign record);
}