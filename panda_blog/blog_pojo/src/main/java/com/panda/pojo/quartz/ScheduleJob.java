package com.panda.pojo.quartz;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "quartz_job")
// @Table指定该实体类对应的表名,如表名为base_customer,类名为BaseCustomer可以不需要此注解
public class ScheduleJob implements Serializable {
    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Integer id;

    /** 任务名称 */
    @Column(name="task_name")
    private String jobName;

    /** 任务分组 */
    @Column(name="task_group")
    private String jobGroup;

    /** 任务状态 0新建 1启用 2暂停*/
    @Column(name="task_status")
    private Integer jobStatus;

    /** 任务运行时间表达式 */
    @Column(name="task_cron")
    private String cronExpression;

    /** 任务执行类 */
    @Column(name="bean_class")
    private String beanClass;

    /** 任务创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date createTime;

    /** 任务更新时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_time")
    private Date updateTime;

    /**触发器*/
    @Column(name="trigger_name")
    private String triggerName;

    /** 任务描述 */
    @Column(name="task_desc")
    private String jobDesc;

    /**是否删除 Y:删除*/
    private Character type;
}
