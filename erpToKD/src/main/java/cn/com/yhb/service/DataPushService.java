package cn.com.yhb.service;

import org.springframework.stereotype.Service;

@Service
public interface DataPushService {

    /**
     * 每周同步一次（贝立）
     */
    void weekDataTimerBL(String startTime, String endTime);

    /**
     * 每月同步一次（贝立）
     */
    void monthDataTimerBL(String startTime, String endTime);


    /**
     * 每周同步一次（咿童）
     */
    void weekDataTimerYT(String startTime, String endTime);

    /**
     * 每月同步一次（咿童）
     */
    void monthDataTimerYT(String startTime, String endTime);
}
