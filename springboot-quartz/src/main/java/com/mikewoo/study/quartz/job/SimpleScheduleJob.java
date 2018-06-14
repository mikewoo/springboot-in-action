package com.mikewoo.study.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Job
 *
 * @auther Phantom Gui
 * @date 2018/6/14 15:41
 */
public class SimpleScheduleJob extends QuartzJobBean {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleScheduleJob.class);

    private String param;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss a");
        LOG.info("simple schedule job running， param: {}, current time: {}", this.param, now.format(format));
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
