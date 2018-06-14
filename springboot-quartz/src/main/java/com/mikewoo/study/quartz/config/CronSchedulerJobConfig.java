package com.mikewoo.study.quartz.config;

import com.mikewoo.study.quartz.job.CronScheduleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Cron 表达式Job配置
 *
 * @auther Phantom Gui
 * @date 2018/6/14 16:09
 */
@Configuration
public class CronSchedulerJobConfig {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    // 启动定时任务
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        setCronScheduleJob(scheduler);
    }

    // 配置定时任务
    private void setCronScheduleJob(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(CronScheduleJob.class) .withIdentity("cronJob", "cronGroup").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("cronTrigger", "cronGroup") .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }
}
