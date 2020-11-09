package cn.com.yhb.ds2.mapper;

import cn.com.yhb.entity.ICStockBillEntry;
import cn.com.yhb.entity.ICStockBillEntryKey;
import org.springframework.stereotype.Component;

@Component
public interface ICStockBillEntry2Mapper {
    int deleteByPrimaryKey(ICStockBillEntryKey key);

    int insert(ICStockBillEntry record);

    int insertSelective(ICStockBillEntry record);

    ICStockBillEntry selectByPrimaryKey(ICStockBillEntryKey key);

    int updateByPrimaryKeySelective(ICStockBillEntry record);

    int updateByPrimaryKey(ICStockBillEntry record);
}