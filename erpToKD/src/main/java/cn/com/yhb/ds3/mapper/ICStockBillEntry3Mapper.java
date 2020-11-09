package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.ICStockBillEntry;
import cn.com.yhb.entity.ICStockBillEntryKey;
import org.springframework.stereotype.Component;

@Component
public interface ICStockBillEntry3Mapper {
    int deleteByPrimaryKey(ICStockBillEntryKey key);

    int insert(ICStockBillEntry record);

    int insertSelective(ICStockBillEntry record);

    ICStockBillEntry selectByPrimaryKey(ICStockBillEntryKey key);

    int updateByPrimaryKeySelective(ICStockBillEntry record);

    int updateByPrimaryKey(ICStockBillEntry record);
}