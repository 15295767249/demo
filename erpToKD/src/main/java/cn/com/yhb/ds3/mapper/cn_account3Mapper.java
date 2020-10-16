package cn.com.yhb.ds3.mapper;

import cn.com.yhb.entity.cn_account;
import org.springframework.stereotype.Component;

@Component
public interface cn_account3Mapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(cn_account record);

    int insertSelective(cn_account record);

    cn_account selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(cn_account record);

    int updateByPrimaryKey(cn_account record);
}