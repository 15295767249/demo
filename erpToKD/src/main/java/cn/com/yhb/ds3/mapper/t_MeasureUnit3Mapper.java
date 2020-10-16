package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.t_MeasureUnit;
import org.springframework.stereotype.Component;

@Component
public interface t_MeasureUnit3Mapper {
    int deleteByPrimaryKey(Integer fmeasureunitid);

    int insert(t_MeasureUnit record);

    int insertSelective(t_MeasureUnit record);

    t_MeasureUnit selectByPrimaryKey(Integer fmeasureunitid);

    int updateByPrimaryKeySelective(t_MeasureUnit record);

    int updateByPrimaryKeyWithBLOBs(t_MeasureUnit record);

    int updateByPrimaryKey(t_MeasureUnit record);
}