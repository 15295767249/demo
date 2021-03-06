package cn.com.yhb.controller;

import cn.com.yhb.service.DataPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class ErpToKDController {

    @Autowired
    DataPushService dataPushService;

    @GetMapping(value = "/weekDataTimer")
    public void weekDataTimer(@RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime) {
        dataPushService.weekDataTimerBL(startTime, endTime);
        dataPushService.weekDataTimerYT(startTime, endTime);
    }

    @GetMapping(value = "/monthDataTimer")
    public void monthDataTimer(@RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime) {
        dataPushService.monthDataTimerBL(startTime, endTime);
        dataPushService.monthDataTimerYT(startTime, endTime);
    }
}
