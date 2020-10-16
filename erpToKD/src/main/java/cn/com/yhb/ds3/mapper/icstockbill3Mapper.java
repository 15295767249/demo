package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.icstockbill;
import org.springframework.stereotype.Component;

@Component
public interface icstockbill3Mapper {
    int deleteByPrimaryKey(Integer finterid);

    int insert(icstockbill record);

    int insertSelective(icstockbill record);

    icstockbill selectByPrimaryKey(Integer finterid);

    int updateByPrimaryKeySelective(icstockbill record);

    int updateByPrimaryKeyWithBLOBs(icstockbill record);

    int updateByPrimaryKey(icstockbill record);
}