package com.wang.server.controller.manage;

import com.wang.server.common.util.ResultCode;
import com.wang.server.common.util.ResultUtils;
import com.wang.server.conf.Server;
import com.wang.server.conf.server.*;
import com.wang.server.service.BlogService;
import com.wang.server.vo.BlogVo;
import com.wang.server.vo.SearchvVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019/5/15 15:54
 * @Description: blog管理
 */
@Slf4j
@RestController
@RequestMapping("/panda/manage/blog")
public class ManageBlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping(value = "/add")
    public String addBlog(BlogVo blog){
        if (null ==blog || StringUtils.isEmpty(blog.getTitle()) ||StringUtils.isEmpty(blog.getContent())){
            return ResultUtils.generateResultStr(ResultCode.PARAM_ERROR, "博客标题、内容不能为空", 0);
        }

        int count = blogService.insert(blog);
        if (count <= 0){
            return ResultUtils.generateResultStr(ResultCode.DATA_ERROR, "插入异常", 0);
        }
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "新增成功", 0);
    }

    @PostMapping("/getblog")
    public String getBlog(Integer id){

        return ResultUtils.generateResultStr(ResultCode.SUCCESS,"查询成功", blogService.selectByid(id));
    }


    @PostMapping("/list")
    public String getBlogs(Integer pageNum, Integer pageSize, SearchvVo search){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", blogService.selectAll(pageNum,pageSize,search));
    }

    @PostMapping("/delete")
    public String delectBlog(Integer id){
        if(id <=0){
          return ResultUtils.generateResultStr(ResultCode.PARAM_ERROR, "id不能为空", 0);
        }
        int count = blogService.deleteByPrimaryKey(id);
        if (count == 0){
            return ResultUtils.generateResultStr(ResultCode.DATA_ERROR, "删除异常", 0);
        }
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "删除成功", 0);
    }

    /**
     * 同步数据到es
     * @return
     */
    @PostMapping("/syncBlog")
    public String syncBlog(){
        blogService.syncBlog();
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "同步成功",0 );
    }

    /**
     * 获取服务器信息
     * @return
     */
    @GetMapping("/server")
    public String server(){
        Server server = new Server();
        ServerVo serverVo = new ServerVo();
        try {
            server.copyTo();
            Mem mem = server.getMem();
            Cpu cpu = server.getCpu();

            Jvm jvm = server.getJvm();
            Sys sys = server.getSys();
            int cpuNum = cpu.getCpuNum();
            double memTotal = mem.getTotal();
            double memUsage = mem.getUsage();
            double memFree = mem.getFree();
            double memUsed = mem.getUsed();
            double jvmTotal = jvm.getTotal();
            double jvmUsage = jvm.getUsage();
            double jvmFree = jvm.getFree();
            double jvmUsed = jvm.getUsed();
            String jvmHome = jvm.getHome();
            String jvmName = jvm.getName();
            String jvmRunTime = jvm.getRunTime();
            String jvmStartTime = jvm.getStartTime();
            String jvmVersion = jvm.getVersion();
            double cpuFree = cpu.getFree();
            double cpuSys = cpu.getSys();
            double cpuTotal = cpu.getTotal();
            double cpuUsed = cpu.getUsed();
            serverVo.setMemTotal(memTotal);
            serverVo.setMemUsage(memUsage);
            serverVo.setMemFree(memFree);
            serverVo.setMemUsed(memUsed);
            serverVo.setJvmTotal(jvmTotal);
            serverVo.setJvmUsage(jvmUsage);
            serverVo.setJvmFree(jvmFree);
            serverVo.setJvmUsed(jvmUsed);
            serverVo.setCpuNum(cpuNum);
            serverVo.setCpuFree(cpuFree);
            serverVo.setCpuSys(cpuSys);
            serverVo.setCpuTotal(cpuTotal);
            serverVo.setCpuUsed(cpuUsed);
            serverVo.setSys(sys);
            serverVo.setSysFiles(server.getSysFiles());
            serverVo.setJvmHome(jvmHome);
            serverVo.setJvmName(jvmName);
            serverVo.setJvmRunTime(jvmRunTime);
            serverVo.setJvmStartTime(jvmStartTime);
            serverVo.setJvmVersion(jvmVersion);


        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取服务器信息异常");
            return ResultUtils.generateResultStr(ResultCode.DATA_ERROR, "获取服务器信息异常",0 );
        }
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "获取服务器信息成功",serverVo);
    }
}
