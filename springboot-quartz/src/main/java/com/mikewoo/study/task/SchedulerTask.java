package com.mikewoo.study.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Springboot内置定时任务，开启内置定时需要使用@{@link EnableScheduling}注解，示例中添加在{@link SchedulerConfig}类上
 *
 * @auther Phantom Gui
 * @date 2018/6/14 15:14
 */
@Component
public class SchedulerTask {
    private static final Logger LOG = LoggerFactory.getLogger(SchedulerTask.class);

    private int count = 1;

    // @Scheduled(fixedRate = 30000)：上一次开始执行时间点之后 30 秒再执行。
    // @Scheduled(fixedDelay = 30000)：上一次执行完毕时间点之后 30 秒再执行。
    // @Scheduled(initialDelay = 10000, fixedRate = 60000)：第一次延迟 10 秒后执行，之后按 fixedRate 的规则每 60 秒执行一次。
    @Scheduled(initialDelay = 10000, fixedRate = 60000)
    public void count() {
        LOG.info("内置定时任务执行，执行次数：{}", (count++));
    }

    // cron 一共有 7 位，最后一位是年，Spring Boot 定时方案中只需要设置 6 位即可
    // - 第一位，表示秒，取值 0-59；
    // - 第二位，表示分，取值 0-59；
    // - 第三位，表示小时，取值 0-23；
    // - 第四位，日期天/日，取值 1-31；
    // - 第五位，日期月份，取值 1-12；
    // - 第六位，星期，取值 1-7，星期一、星期二…；
    // - 第七位，年份，可以留空，取值 1970-2099。
    @Scheduled(cron = "*/30 * * * * * ")
    public void printTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss a");
        LOG.info("内置定时任务执行，当前时间：{}", now.format(format));
    }
}
