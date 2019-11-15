package com.panda.admin.quartz.config;


import com.panda.admin.quartz.service.ScheduleJobService;
import com.panda.pojo.quartz.ScheduleJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 定时任务调度类
 *
 * @Authur fkj
 * @Create 2018/11/14
 * ================================
 * @update 2018/11/21 初始化调度器
 */

@Slf4j
@Service
public class ScheduleJobMethod implements InitializingBean {
    protected static final int JOB_STATUS = 1;

    @Autowired
    private ScheduleJobService scheduleJobService;
    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    /**
     * 服务重启后初始化任务
     */
    public void init() {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        List<ScheduleJob> list = scheduleJobService.getAllSchedJobs();
        for (ScheduleJob scheduleJob : list) {
            try {
                TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(scheduleJob.getId()), scheduleJob.getTriggerName());
                CronTrigger triggers = (CronTrigger) scheduler.getTrigger(triggerKey);
                if (triggers == null) {
                    String bean = scheduleJob.getBeanClass();
                    Class clazz = Class.forName(bean);
                    // 任务名，任务组，任务执行类
                    JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(String.valueOf(scheduleJob.getId()), scheduleJob.getJobGroup()).build();
                    // 触发器
                    TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                    // 触发器名,触发器组
                    triggerBuilder.withIdentity(String.valueOf(scheduleJob.getId()), scheduleJob.getTriggerName());
                    triggerBuilder.startNow();
                    // 触发器时间设定
                    triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression()));
                    // 创建Trigger对象
                    CronTrigger trigger = (CronTrigger) triggerBuilder.build();
                    //添加
                    jobDetail.getJobDataMap().put("scheduleJob", scheduleJob);
                    // 调度容器设置JobDetail和Trigger
                    scheduler.scheduleJob(jobDetail, trigger);
                    //启动
                    if (scheduleJob.getJobStatus() != JOB_STATUS) {
                        JobKey jobKey = JobKey.jobKey(String.valueOf(scheduleJob.getId()), scheduleJob.getJobGroup());
                        scheduler.pauseJob(jobKey);
                    }
                    if (!scheduler.isShutdown()) {
                        scheduler.start();
                    }
                }
            } catch (Exception e) {

                continue;
            }
        }
        log.info("初始化任务成功");
    }

    public void addJob(ScheduleJob scheduleJob) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobKey jobKey = JobKey.jobKey(String.valueOf(scheduleJob.getId()), scheduleJob.getJobGroup());
            //如果不存在创建一个
            if (!scheduler.checkExists(jobKey)) {
                Class jobClass = Class.forName(scheduleJob.getBeanClass());
                // 任务名，任务组，任务执行类
                JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(String.valueOf(scheduleJob.getId()), scheduleJob.getJobGroup()).build();
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(String.valueOf(scheduleJob.getId()), scheduleJob.getTriggerName());
                triggerBuilder.startNow();
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression()));
                // 创建Trigger对象
                CronTrigger trigger = (CronTrigger) triggerBuilder.build();
                //添加
                jobDetail.getJobDataMap().put("scheduleJob", scheduleJob);
                // 调度容器设置JobDetail和Trigger
                scheduler.scheduleJob(jobDetail, trigger);
                //启动
                if (!scheduler.isShutdown()) {
                    scheduler.start();
                    log.info("调度器启动......");
                }
                if (scheduleJob.getJobStatus() != JOB_STATUS) {
                    JobKey jobKeys = JobKey.jobKey(String.valueOf(scheduleJob.getId()), scheduleJob.getJobGroup());
                    scheduler.pauseJob(jobKeys);
                }
                log.info("增加任务到调度器,任务名称:{}", scheduleJob.getJobName());
            } else {
                TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(scheduleJob.getId()), scheduleJob.getTriggerName());
                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                if (trigger == null) {
                    return;
                }
                String oldTime = trigger.getCronExpression();
                if (!oldTime.equalsIgnoreCase(scheduleJob.getCronExpression())) {
                    // 触发器
                    JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                    Trigger newTrigger = TriggerBuilder.newTrigger()
                            .forJob(jobDetail)
                            .withSchedule(CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression()))
                            .withIdentity(new TriggerKey(String.valueOf(scheduleJob.getId()), scheduleJob.getTriggerName()))
                            .build();
                    // 方式一 ：修改一个任务的触发时间
                    scheduler.rescheduleJob(triggerKey, newTrigger);
                    //scheduler.resumeTrigger(triggerKey);
                    if (scheduleJob.getJobStatus() != JOB_STATUS) {
                        JobKey jobKeys = JobKey.jobKey(String.valueOf(scheduleJob.getId()), scheduleJob.getJobGroup());
                        scheduler.pauseJob(jobKeys);
                    }
                }
                log.info("修改任务:{}", scheduleJob.getJobName());
            }
        } catch (Exception e) {
            log.error("add or update Task fail .", e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 开启一个任务
     * @param scheduleJob
     */
    public void runJobNow(ScheduleJob scheduleJob) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(String.valueOf(scheduleJob.getId()), scheduleJob.getJobGroup());
        try {
            //  scheduler.triggerJob(jobKey);      立即执行
            //恢复
            scheduler.resumeJob(jobKey);
            SchedulerMetaData metaData = scheduler.getMetaData();
            log.info("开启任务成功", metaData.getNumberOfJobsExecuted());
        } catch (SchedulerException e) {
            log.error("Task run failed.", e);
        }
    }

    /**
     * 暂停一个任务
     *
     * @param scheduleJob
     */
    public void standJobNow(ScheduleJob scheduleJob) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(String.valueOf(scheduleJob.getId()), scheduleJob.getJobGroup());
        try {
            scheduler.pauseJob(jobKey);
            scheduler.interrupt(jobKey);
            log.info("暂停任务:{} ", scheduleJob.getJobName());
        } catch (SchedulerException e) {
            log.error("Task run failed.", e);
        }
    }

    /**
     * 启动所有定时任务
     */
    public void startJobs() {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            scheduler.resumeAll();
            log.info("启动所有任务");
        } catch (Exception e) {
            log.error("Task run failed.", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 停止所有任务
     */
    public void shutdownJobs() {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            if (!scheduler.isShutdown()) {
                scheduler.pauseAll();
                log.info("停止所有任务");
            }
        } catch (Exception e) {
            log.error("Task stop failed.", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除一个任务
     */
    public void removeJob(List<ScheduleJob> list) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            for (int i = 0; i < list.size(); i++) {
                ScheduleJob scheduleJob = list.get(i);
                if (scheduleJob.getJobStatus() != 0) {
                    TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(scheduleJob.getId()), scheduleJob.getTriggerName());
                    // 停止触发器
                    scheduler.pauseTrigger(triggerKey);
                    // 移除触发器
                    scheduler.unscheduleJob(triggerKey);
                    // 删除任务
                    scheduler.deleteJob(JobKey.jobKey(String.valueOf(scheduleJob.getId()), scheduleJob.getJobGroup()));
                }
            }
            log.info("删除任务成功");
        } catch (Exception e) {
            log.error("delete job fail", e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 验证cron表达式是否有效
     *
     * @param expression
     * @return
     */
    public Boolean isVaild(String expression) {
        boolean bool = CronExpression.isValidExpression(expression);
        return bool;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       // init();
    }
}
