package cn.com.yhb.schedule;

import cn.com.yhb.service.DataPushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${schedule.data.switch}")
    private boolean schedule_data_switch;

    @Autowired
    DataPushService dataPushService;

    //秒（0-59），分，小时（0-23），日期天/日（1-31），日期月份（1-12），星期（1-7），年（1970-2099，可以省略）

    /**
     * 定时器：每周一零点同步ERP数据到本地备份SQL server数据库（SUN,MON,TUE,WED,THU,FRI,SAT）
     */
    @Scheduled(cron = "0 0 0 ? * MON")
//    @Scheduled(cron = "0 48 8 ? * WED")
    public void weekDataTimer() {
        try {
            if (schedule_data_switch) {
                System.out.println("周开启定时器......................");
                dataPushService.weekDataTimerBL("", "");
                dataPushService.weekDataTimerYT("", "");
            }
        } catch (Exception e) {
            logger.info(e.toString());
        }
    }

    /**
     * 定时器：每月1日零点同步ERP数据到本地备份SQL server数据库
     */
    @Scheduled(cron = "0 0 0 1 * ?")
    public void monthDataTimer() {
        try {
            if (schedule_data_switch) {
                dataPushService.monthDataTimerBL("", "");
                dataPushService.monthDataTimerYT("", "");
            }
        } catch (Exception e) {
            logger.info(e.toString());
        }
    }

}
