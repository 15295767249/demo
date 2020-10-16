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
    public void weekDataTimer(@RequestParam(value = "startTime") String startTime) {
        dataPushService.weekDataTimer(startTime);
    }

    @GetMapping(value = "/monthDataTimer")
    public void monthDataTimer() {
        dataPushService.monthDataTimer();
    }
}
