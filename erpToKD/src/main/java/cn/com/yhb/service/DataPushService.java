package cn.com.yhb.service;

import org.springframework.stereotype.Service;

@Service
public interface DataPushService {

    /**
     * 每周同步一次
     */
    void weekDataTimer(String startTime);

    /**
     * 每月同步一次
     */
    void monthDataTimer(String startTime);
}
