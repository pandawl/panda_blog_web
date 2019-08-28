package com.wang.server.conf.server;

import lombok.Data;

import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/8/28 11:26
 * @Description:
 */
@Data
public class ServerVo {

    private double memTotal ;
    private double memUsage ;
    private double memFree ;
    private double memUsed ;
    private double jvmTotal ;
    private double jvmUsage ;
    private double jvmFree ;
    private double jvmUsed ;
    String jvmHome ;
    String jvmName ;
    String jvmRunTime ;
    String jvmStartTime;
    String jvmVersion;
    private int cpuNum;
    private double cpuFree ;
    private double cpuSys ;
    private double cpuTotal  ;
    private double cpuUsed  ;
    private Sys sys;
    private List<SysFile> sysFiles;

}
