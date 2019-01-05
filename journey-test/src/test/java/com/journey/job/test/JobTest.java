package com.journey.job.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by liuqingwen on 2017/8/10.
 */
@Component
public class JobTest {

    @Scheduled(cron = "")
    public void doExe() {
        System.out.println(1);
    }


}
