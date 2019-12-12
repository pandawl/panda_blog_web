package com.panda.admin.quartz.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;


/**
 * @Auther: wl
 * @Date: 2019/8/29 10:27
 * @Description:
 */
@Configuration
public class ScheduleConfig {

    @Resource
    private SpringJobFactory springJobFactory;


/* 这里我们需要注意 我注入了一个 自定义的JobFactory ，然后 把其设置为SchedulerFactoryBean 的 JobFactory。其目的是因为我在具体的Job 中 需要Spring 注入一些Service。
    所以我们要自定义一个jobfactory， 让其在具体job 类实例化时 使用Spring 的API 来进行依赖注入*/

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(springJobFactory);
        return factory;
    }

    @Bean
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }
}

