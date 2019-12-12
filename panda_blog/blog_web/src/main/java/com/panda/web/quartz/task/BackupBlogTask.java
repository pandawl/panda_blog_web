/*
package com.panda.web.quartz.task;

import com.panda.common.util.DatabaseUtil;
import com.panda.web.quartz.service.ScheduleJobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

*/
/**
 * @Auther: wl
 * @Date: 2019/9/2 16:42
 * @Description: 备份数据库
 *//*

@Slf4j
@DisallowConcurrentExecution
public class BackupBlogTask implements Job {

    @Autowired
    ScheduleJobService scheduleJobService;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String todayStr = sdf.format(today);
        log.info("开始备份{}日Blog",todayStr);
        long preStart = System.currentTimeMillis();
        scheduleJobService.logs(context, "开始备份"+todayStr+"日Blog");


        String command = "sh panda_blog.sh";
        
        boolean b1 = new DatabaseUtil().shell(command);
        if(b1){
            log.info("备份{}日blog成功",todayStr);
        }else {
            log.error("备份{}日blog失败",todayStr);
        }

        long preEnd = System.currentTimeMillis();
        log.info("备份Blog完毕，用时:{}秒", (preEnd - preStart) / 1000);
        scheduleJobService.logs(context,"备份"+todayStr+"Blog完毕,用时"+(preEnd - preStart) / 1000+"秒");

    }
}
*/
