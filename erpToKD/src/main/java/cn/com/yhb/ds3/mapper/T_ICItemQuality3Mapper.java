package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_ICItemQuality;
import org.springframework.stereotype.Component;

@Component
public interface T_ICItemQuality3Mapper {
    int deleteByPrimaryKey(Integer fitemid);

    int insert(t_ICItemQuality record);

    int insertSelective(t_ICItemQuality record);

    t_ICItemQuality selectByPrimaryKey(Integer fitemid);

    int updateByPrimaryKeySelective(t_ICItemQuality record);

    int updateByPrimaryKey(t_ICItemQuality record);
}