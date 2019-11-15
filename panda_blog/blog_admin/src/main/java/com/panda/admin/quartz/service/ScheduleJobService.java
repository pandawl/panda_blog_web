package com.panda.admin.quartz.service;

import com.github.pagehelper.PageInfo;
import com.panda.pojo.quartz.ScheduleJob;
import com.panda.pojo.quartz.ScheduleJobLog;
import com.panda.vo.SearchvVo;
import org.quartz.JobExecutionContext;

import java.util.List;

/**
 * 定时任务接口
 * @Authur fkj
 * @Create 2018/11/14
 * ====================
 */
public interface ScheduleJobService {

    /**
     * 获取所有的定时任务
     *
     * @return
     */
    PageInfo<ScheduleJob> getAllJobs(int pageNum, int pageSize);

    /**
     * 初始化查询(查询所有的任务)
     *
     * @return
     */
    List<ScheduleJob> getAllSchedJobs();

    /**
     * 根据条件查询
     */
    PageInfo<ScheduleJob> getJobList(int pageNum, int pageSize, SearchvVo searchvVo);


    /**
     * 根据id查询任务列表
     * @param ids
     * @return
     */
    List<ScheduleJob> getJobs(String ids);

    /**
     * 新增一条定时任务
     *
     * @param job
     */
    void inserJob(ScheduleJob job);

    /**
     * 更新一条定时任务
     * @param job
     */

    void updateJob(ScheduleJob job);

    /**
     * 删除一条定时任务
     * @param id
     */
    void deleteJob(Integer id);


    /**
     * 批量删除
     */
    void deleteJobs(String id);


    /**
     * 根据任务id查询任务
     * @param id
     * @return
     */
    ScheduleJob getScheduleJobById(int id);

    /**
     * 记录日志
     *
     * @param id
     */
    void writeLog(Integer id, String s, String ip);


    /**
     * 查询日志
     *
     * @return
     */
    List<ScheduleJobLog> findAllOperLog(String userName, String startTime, String endTime, String logType, int offset, int limit);

    /**
     * 记录运行日志
     *  @param jobExecutionContext
     */
    void logs(JobExecutionContext jobExecutionContext, String content);


    /**
     * 查询日志总条数
     * @param userName
     * @param startTime
     * @param endTime
     * @param logType
     * @return
     */
    int getCountBySqls(String userName, String startTime, String endTime, String logType);

    /**
     * 批量删除日志
     * @param ids
     */
    void deteteLOg(String ids);

    /**
     * 一键清楚日志
     */
    void deteteAllLOg();

    /**
     * 查询任务的总条数
     * @param
     */

    int countAlls(String departmentname, String statu);
}
