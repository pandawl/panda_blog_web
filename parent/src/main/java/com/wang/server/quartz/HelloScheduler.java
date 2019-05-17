package com.wang.server.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Auther: wl
 * @Date: 2019/5/17 17:04
 * @Description:
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {
        JobDetail myJob = JobBuilder.newJob(QuartzController.class).withIdentity("myJob").build();
        SimpleTrigger myTrigger = TriggerBuilder.newTrigger().withIdentity("myTrigger").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(myJob, myTrigger);

    }
}
