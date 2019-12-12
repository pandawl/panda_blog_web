package com.panda.admin.quartz.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panda.admin.quartz.service.ScheduleJobService;
import com.panda.dao.ScheduleJobLogMapper;
import com.panda.dao.ScheduleJobMapper;
import com.panda.pojo.quartz.ScheduleJob;
import com.panda.pojo.quartz.ScheduleJobLog;
import com.panda.vo.SearchvVo;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 定时任务实现接口
 *
 * @Authur fkj
 * @Create 2018/11/14
 * =====================
 * @update 2018/11/22 对删除进行批处理
 */
@Service
@Slf4j
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobMapper, ScheduleJob> implements ScheduleJobService {

    @Autowired
    ScheduleJobMapper jobMapper;

    @Autowired
    ScheduleJobLogMapper logMapper;

    /**
     * 操作日志
     */
    protected static final int LOG_TYPE_ONE = 0;
    /**
     * 运行日志
     */
    protected static final int LOG_TYPE_TWO = 1;


    @Override
    public List<ScheduleJob> getAllJobs(int pageNum, int pageSize) {
        List<ScheduleJob> jobs = jobMapper.selectList(new QueryWrapper<>());
        return jobs;
    }

    @Override
    public List<ScheduleJob> getAllSchedJobs() {
        return jobMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<ScheduleJob> getJobList(int pageNum, int pageSize, SearchvVo searchvVo) {
/*        Example example = new Example(ScheduleJob.class);
        Example.Criteria criteria = example.createCriteria();
        if (null != searchvVo){
            if (null != searchvVo.getValue()){
                criteria.andEqualTo("jobStatus", searchvVo.getValue());
            }
            if (null != searchvVo.getSearchName()){
                criteria.andLike("jobName", "%"+searchvVo.getSearchName()+"%");
            }
        }
        List<ScheduleJob> jobs = jobMapper.selectByExample(example);
        return jobs;*/
        return null;

    }


    @Override
    public List<ScheduleJob> getJobs(String ids) {
      /*  String sql = "select * from t_s_task where id in (" + ids + ")";
        List<ScheduleJob> list = findListbySql(sql, ScheduleJob.class);
        return list;*/
        return null;
    }


    @Override
    public void inserJob(ScheduleJob job) {
        /*save(job);*/
    }

    @Override
    public void updateJob(ScheduleJob job) {
        // jobMapper.updateByPrimaryKey(job);

    }

    @Override
    public void deleteJob(Integer id) {
        /*    deleteEntityById(ScheduleJob.class, id);*/
    }


    @Override
    public ScheduleJob getScheduleJobById(int id) {
        //  ScheduleJob job = jobMapper.selectByPrimaryKey(id);
        return null;
    }

    /**
     * 记录操作任务日志
     *
     * @param jobId
     */
    @Override
    public void writeLog(Integer jobId, String type, String ip) {
        ScheduleJobLog scheduleJobLog = new ScheduleJobLog();
        scheduleJobLog.setContent(type);
        scheduleJobLog.setCreateTime(new Date());
        scheduleJobLog.setLogType(LOG_TYPE_ONE);

        if (null != jobId) {
            scheduleJobLog.setJobId(jobId);
        }
        scheduleJobLog.setIp(ip);
        logMapper.insert(scheduleJobLog);
    }

    /**
     * 记录运行日志
     *
     * @param jobExecutionContext
     */
    @Override
    public void logs(JobExecutionContext jobExecutionContext, String content) {
     /*   ScheduleJob scheduleJob = (ScheduleJob) jobExecutionContext.getJobDetail().getJobDataMap().get("scheduleJob");
        int jobId = scheduleJob.getId();
        ScheduleJobLog scheduleJobLog = new ScheduleJobLog();
        scheduleJobLog.setContent(content);
        scheduleJobLog.setLogType(LOG_TYPE_TWO);
        scheduleJobLog.setCreateTime(new Date());
        scheduleJobLog.setJobId(jobId);
        save(scheduleJobLog);*/
    }


    /**
     * 查询所有的定时任务的操作日志
     *
     * @return
     */
    @Override
    public List<ScheduleJobLog> findAllOperLog(String userName, String startTime, String endTime, String logType, int offset, int limit) {
    /*    StringBuilder sql = new StringBuilder();
        sql.append(" SELECT  l.*,  " +
                "    (CASE   WHEN l.log_type = 1 THEN 'system' ELSE u.username  " +
                "    END) username,  t.job_name  " +
                "FROM  " +
                "    t_s_task_log l   LEFT JOIN  " +
                "    t_s_task_user u ON u.id = l.user_id LEFT JOIN  " +
                "    t_s_task t ON t.id = l.job_id  " +
                "WHERE   1 = 1");
        if (StringUtils.isNotBlank(userName)) {
            sql.append(" AND u.username like '%" + userName + "%' ");
        }
        if (StringUtils.isNotBlank(logType)) {
            sql.append(" AND l.log_type = '" + logType + "'");
        }
        if (StringUtils.isNotBlank(startTime)) {
            sql.append(" AND l.create_time > '" + startTime + "' ");
        }
        if (StringUtils.isNotBlank(endTime)) {
            sql.append(" AND l.create_time < '" + endTime + "'  ");
        }
        sql.append(" order by l.create_time desc");
        sql.append(" LIMIT " + offset + " , " + limit);
        List scheduleJobLogs = listBySQL(sql.toString());
        return scheduleJobLogs;*/
        return null;
    }

    /**
     * 查询日志总条数
     *
     * @param userName
     * @param startTime
     * @param endTime
     * @param logType
     * @return
     */
    @Override
    public int getCountBySqls(String userName, String startTime, String endTime, String logType) {
/*        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT                                 ");
        sql.append("    count(1)                            ");
        sql.append(" FROM                                   ");
        sql.append("     t_s_task_log l                     ");
        sql.append("         left JOIN                      ");
        sql.append("     t_s_task_user u ON u.id = l.user_id");
        sql.append("         left JOIN                      ");
        sql.append("     t_s_task t ON t.id = l.job_id      ");
        sql.append(" WHERE  1=1                             ");
        if (StringUtils.isNotBlank(userName)) {
            sql.append(" AND u.username like '%" + userName + "%' ");
        }
        if (StringUtils.isNotBlank(logType)) {
            sql.append(" AND l.log_type = '" + logType + "'");
        }
        if (StringUtils.isNotBlank(startTime)) {
            sql.append(" AND l.create_time > '" + startTime + "' ");
        }
        if (StringUtils.isNotBlank(endTime)) {
            sql.append(" AND l.create_time < '" + endTime + "'  ");
        }
        int count = getCountBySql(sql.toString());
        return count;*/
        return 0;
    }

    /**
     * 批量删除日志
     *
     * @return ids
     */
    @Override
    public void deteteLOg(String ids) {
       /* String sql = "delete from t_s_task_log where id in (" + ids + ")";
        executeSQL(sql);*/
    }


    @Override
    public void deteteAllLOg() {
       /* String sql = "delete  from t_s_task_log where 1=1";
        executeSQL(sql);*/
    }


    @Override
    public int countAlls(String departmentname, String statu) {
      /*  StringBuilder sql = new StringBuilder();
        sql.append(" SELECT                                 ");
        sql.append("    count(1) ");
        sql.append(" FROM                                   ");
        sql.append("     t_s_task                  ");
        sql.append(" WHERE  type is null                          ");
        if (StringUtils.isNotBlank(departmentname)) {
            sql.append(" AND job_name like '%" + departmentname + "%' ");
        }
        if (StringUtils.isNotBlank(statu)) {
            sql.append(" AND job_status = '" + statu + "'");
        }

        int count = getCountBySql(sql.toString());
        return count;*/
        return 0;
    }


    /**
     * 批量删除任务
     * 逻辑删除
     *
     * @param id
     */
    @Override
    public void deleteJobs(String id) {
    }

}
