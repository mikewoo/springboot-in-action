package com.mikewoo.study.quartz.config;

import com.mikewoo.study.quartz.job.SimpleScheduleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Quartz Job配置
 *
 * @auther Phantom Gui
 * @date 2018/6/14 15:45
 */
@Configuration
public class QuartzSchedulerConfig {

    @Bean
    public JobDetail SimpleScheduleJobDetail() {
        return JobBuilder.newJob(SimpleScheduleJob.class).withIdentity("simpleScheduleJob")
                .usingJobData("param", "springboot").storeDurably().build();
    }

    @Bean
    public Trigger SimpleScheduleJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();

        return TriggerBuilder.newTrigger().forJob(SimpleScheduleJobDetail())
                .withIdentity("simpleScheduleJobTrigger").withSchedule(scheduleBuilder).build();
    }
}
