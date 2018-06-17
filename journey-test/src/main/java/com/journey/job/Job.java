package com.journey.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by liuqingwen on 2017/8/10.
 */
@Component
public class Job {

    @Scheduled(cron = "1 0 1 1 * ?")
    public void doExe() {
        System.out.println(format(Calendar.getInstance().getTime()));
    }

    @Scheduled(cron = "* * * * * ?")
    public void doExe1() {
        System.out.println(format(Calendar.getInstance().getTime()));
    }

    @Scheduled(cron = "1 * * * * ?")
    public void doExe2() {
        System.out.println("2... " + format(Calendar.getInstance().getTime()));
    }

    @Scheduled(cron = "0 1 * * * ?")
    public void doExe3() {
        System.out.println("3... " + format(Calendar.getInstance().getTime()));
    }

    @Scheduled(cron = "0 35 * * * ?")
    public void doExe4() {
        System.out.println("4... " + format(Calendar.getInstance().getTime()));
    }

    @Scheduled(cron = "0 35 16 * * ?")
    public void doExe5() {
        System.out.println("5... " + format(Calendar.getInstance().getTime()));
    }

    @Scheduled(cron = "0 35 17 * * ?")
    public void doExe6() {
        System.out.println("6... " + format(Calendar.getInstance().getTime()));
    }

    @Scheduled(cron = "0 * * * * ?")
    public void doExe7() {
        System.out.println("7... " + format(Calendar.getInstance().getTime()));
    }

    @Schedules(value = {@Scheduled(cron = "0/6 * * * * ?"), @Scheduled(cron = "0 0/1 * * * ?")})
    public void doExe8() {
        System.out.println("8... " + format(Calendar.getInstance().getTime()));
    }

    private static String format(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

}
