package com.wang.server.controller.task;

import com.wang.server.common.util.ResultCode;
import com.wang.server.common.util.ResultUtils;
import com.wang.server.quartz.service.ScheduleJobService;
import com.wang.server.vo.SearchvVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: wl
 * @Date: 2019/8/30 10:45
 * @Description:
 *
 *  * 对账任务管理
 *  * <p>
 *  * =============================================
 *  * OPERATE_* 1:新增 2:修改 3:删除 4:停止 5 :开启
 *  * JOB_* 0:新增 1 开启 2 停止
 *  * =============================================
 *  *
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
}
