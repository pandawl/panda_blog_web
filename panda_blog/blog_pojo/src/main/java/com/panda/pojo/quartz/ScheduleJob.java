package com.panda.pojo.quartz;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
// @Table指定该实体类对应的表名,如表名为base_customer,类名为BaseCustomer可以不需要此注解
public class ScheduleJob implements Serializable {
    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
    @Id
    private Integer id;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务分组
     */
    private String jobGroup;

    /**
     * 任务状态 0新建 1启用 2暂停
     */
    private Integer jobStatus;

    /**
     * 任务运行时间表达式
     */
    private String cronExpression;

    /**
     * 任务执行类
     */
    private String beanClass;

    /**
     * 任务创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 任务更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 触发器
     */
    private String triggerName;

    /**
     * 任务描述
     */
    private String jobDesc;

    /**
     * 是否删除 Y:删除
     */
    private Character type;
}
