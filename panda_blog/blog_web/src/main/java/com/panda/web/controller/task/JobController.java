package com.panda.web.controller.task;

import com.panda.common.util.IpUtils;
import com.panda.common.util.ResultCode;
import com.panda.common.util.ResultUtils;
import com.panda.pojo.quartz.ScheduleJob;
import com.panda.vo.SearchvVo;
import com.panda.web.quartz.config.ScheduleJobMethod;
import com.panda.web.quartz.service.ScheduleJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wl
 * @Date: 2019/8/30 10:45
 * @Description: * 对账任务管理
 * * <p>
 * * =============================================
 * * OPERATE_* 1:新增 2:修改 3:删除 4:停止 5 :开启
 * * JOB_* 0:新增 1 开启 2 停止
 * * =============================================
 * *
 */
@Controller
@Slf4j
@RequestMapping("/panda/task")
public class JobController {
    protected static final int JOB_STATE_ADD = 0;
    protected static final int JOB_STATE_START = 1;
    protected static final int JOB_STATE_STOP = 2;
    protected static final String OPERATE_ADD = "新增任务";
    protected static final String OPERATE_UPDATE = "修改任务";
    protected static final String OPERATE_DEL = "删除任务";
    protected static final String OPERATE_STOP = "停止任务";
    protected static final String OPERATE_START = "开启任务";

    @Autowired
    private ScheduleJobService scheduleJobService;

    @Autowired
    private ScheduleJobMethod scheduleJobMethod;

    /**
     * 定时任务列表
     *
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public String getlist(Integer pageNum, Integer pageSize, SearchvVo searchvVo) {
        log.info("加载对账任务列表");
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", scheduleJobService.getJobList(pageNum, pageSize, searchvVo));
    }

    /**
     * 定时任务列表
     *
     * @return
     */
    @PostMapping("/start")
    @ResponseBody
    public String startTask(int id, HttpServletRequest request) {
        log.info("启动定时任务");
        ScheduleJob scheduleJob = scheduleJobService.getScheduleJobById(id);
        scheduleJob.setJobStatus(JOB_STATE_START);
        scheduleJobService.updateJob(scheduleJob);
        /**新增不放进调度器里,启动时加入调度器*/
        scheduleJobMethod.addJob(scheduleJob);
        /**加入调度器开启任务*/
        scheduleJobMethod.runJobNow(scheduleJob);
        String ip = IpUtils.getIpAddr(request);
        scheduleJobService.writeLog(scheduleJob.getId(), OPERATE_START,ip);
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "启动成功", 0);

    }

    /**
     * 停止一个执行定时任务
     *
     * @param job 任务实体
     * @return
     */
    @PostMapping(value = "/stop/one")
    @ResponseBody
    public String stopJob(ScheduleJob job, int id, HttpServletRequest request) {
        log.info("停止定时任务");
        ScheduleJob scheduleJob = scheduleJobService.getScheduleJobById(id);
        if (null != scheduleJob) {
            scheduleJob.setJobStatus(JOB_STATE_STOP);
            scheduleJobService.updateJob(scheduleJob);
            scheduleJobMethod.standJobNow(scheduleJob);
            String ip= IpUtils.getIpAddr(request);
            scheduleJobService.writeLog(scheduleJob.getId(), OPERATE_STOP, ip);
            return ResultUtils.generateResultStr(ResultCode.SUCCESS, "停止成功", 0);
        }
        return ResultUtils.generateResultStr(ResultCode.DATA_ERROR, "停止异常", 0);
    }


}
