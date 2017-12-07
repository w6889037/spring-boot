package com.boot.common.schedule;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by xianchun.hu on 12/7/2017.
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {

    private static Logger LOG = Logger.getLogger(SchedulingConfig.class);

    /**
     * 1．秒（0–59）
     * 2．分钟（0–59）
     * 3．小时（0–23）
     * 4．日期（1–31）
     * 5．月份（1–12或JAN–DEC）
     * 6．年份（1970–2099）
     */
    @Scheduled(cron = "0/3 * * * * *")
    public void schedule(){
        LOG.info("每三秒执行一次......");
    }
}
