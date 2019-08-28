<!-- 同步es -->
<template>
  <div class="server">
    <div class="top">
      <div class="left">
        <el-card class="box-card">
          <h2>CPU</h2>
          <el-divider></el-divider>
          <table class="table table-hover no-margins">
            <thead>
              <tr>
                <th>属性</th>
                <th>值</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>核心数</td>
                <td>{{server.cpuNum}}</td>
              </tr>
              <tr>
                <td>用户使用率</td>
                <td>{{server.cpuUsed}}%</td>
              </tr>
              <tr>
                <td>系统使用率</td>
                <td>{{server.cpuSys + '%'}}</td>
              </tr>
              <tr>
                <td>当前空闲率</td>
                <td>{{server.cpuFree}}%</td>
              </tr>
            </tbody>
          </table>
        </el-card>
      </div>
      <div class="right">
        <el-card class="box-card">
          <h2>内存</h2>
          <el-divider></el-divider>
          <table class="table table-hover no-margins">
            <thead>
              <tr>
                <th>属性</th>
                <th>内存</th>
                <th>JVM</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>总内存</td>
                <td>{{server.memTotal + 'G'}}</td>
                <td>{{server.jvmTotal + 'M'}}</td>
              </tr>
              <tr>
                <td>已用内存</td>
                <td>{{server.memUsed + 'G'}}</td>
                <td>{{server.jvmUsed+ 'M'}}</td>
              </tr>
              <tr>
                <td>剩余内存</td>
                <td>{{server.memFree + 'G'}}</td>
                <td>{{server.jvmFree + 'M'}}</td>
              </tr>
              <tr>
                <td>使用率</td>
                <td
                  :style="'color:'+(server.memUsage>80?'red':'green')+';'"
                >{{server.memUsage+ '%' }}</td>
                <td
                  :style="'color:'+(server.jvmUsage>80?'red':'green')+';'"
                >{{server.jvmUsage+ '%' }}</td>
              </tr>
            </tbody>
          </table>
        </el-card>
      </div>
    </div>
    <div class="center">
      <el-card class="box-card">
        <h2>服务器信息</h2>
        <el-divider></el-divider>
                  <table class="table table-hover margin bottom">
                                        <tbody>
                                            <tr>
                                                <td>服务器名称</td>
                                                <td >{{server.sys.computerName}}</td>
                                                <td>操作系统</td>
                                                <td >{{server.sys.osName}}</td>
                                            </tr>
                                            <tr>
                                                <td>服务器IP</td>
                                                <td >{{server.sys.computerIp}}</td>
                                                <td>系统架构</td>
                                                <td >{{server.sys.osArch}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
      </el-card>
    </div>
    <div class="center">
      <el-card class="box-card">
        <h2>Java虚拟机信息</h2>
        <el-divider></el-divider>
                  <table class="table table-hover margin bottom">
                                        <tbody>
                                            <tr>
                                                <td>Java名称</td>
                                                <td >{{server.jvmName}}</td>
                                                <td>Java版本</td>
                                                <td >{{server.jvmVersion}}</td>
                                            </tr>
                                            <tr>
                                                <td>启动时间</td>
                                                <td >{{server.jvmStartTime}}</td>
                                                <td>运行时长</td>
                                                <td >{{server.jvmRunTime}}</td>
                                            </tr>
                                            <tr>
                                                <td colspan="1">安装路径</td>
                                                <td colspan="3" >{{server.jvmHome}}</td>
                                            </tr>
                                             <tr>
                                                <td colspan="1">项目路径</td>
                                                <td colspan="3" >{{server.sys.userDir}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
      </el-card>
    </div>
    <div class="center">
      <el-card class="box-card">
        <h2>磁盘状态</h2>
        <el-divider></el-divider>
      <table class="table table-hover margin bottom">
                                        <thead>
                                            <tr>
                                                <th>盘符路径</th>
                                                <th>文件系统</th>
                                                <th>盘符类型</th>
                                                <th>总大小</th>
                                                <th>可用大小</th>
                                                <th>已用大小</th>
                                                <th>已用百分比</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr v-for="sysFile in sysFiles" :key="sysFile.index" >
                                                <td th:text="${sysFile.dirName}">{{sysFile.dirName}}</td>
                                                <td th:text="${sysFile.sysTypeName}">{{sysFile.sysTypeName}}</td>
                                                <td th:text="${sysFile.typeName}">{{sysFile.typeName}}</td>
                                                <td th:text="${sysFile.total}">{{sysFile.total}}</td>
                                                <td th:text="${sysFile.free}">{{sysFile.free}}</td>
                                                <td th:text="${sysFile.used}">{{sysFile.used}}</td>
                                                <td  :style="'color:'+(sysFile.usage>80?'red':'green')+';'">{{sysFile.usage+'%'}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
      </el-card>
    </div>
  </div>
</template>

<script>
import { syncBlog, getServer } from "../../api/blog";
export default {
  data() {
    return {
      server: {
        sys:{},
        
      },
sysFiles:[]
    };
  },

  components: {},

  computed: {},

  mounted() {
    getServer().then(res => {
      this.server = res.data.resultJson;
      this.sysFiles = res.data.resultJson.sysFiles;
      console.log(this.server);
      console.log(this.sysFiles);
    });
  },

  methods: {
    sync() {
      syncBlog().then(res => {
        if (res.data.resultCode == 200) {
          this.$message({
            message: res.data.resultMessage,
            type: "success",
            showClose: true,
            duration: 1000
          });
        } else {
          this.$message({
            message: res.data.resultMessage,
            type: "error",
            showClose: true,
            duration: 1000
          });
        }
      });
    },
    init() {}
  }
};
</script>
<style lang='scss' scoped>
.left {
  width: 48%;
  float: left;
}
.right {
  width: 48%;
  float: right;
}
.table {
  width: 100%;
  max-width: 100%;
}
th {
  text-align: left;
}
.box-card {
  background-color: #ffffff;
  color: inherit;
  padding: 15px 20px 20px 20px;
  border-color: #e7eaec;
  border-image: none;
  border-style: solid solid none;
  border-width: 1px 0px;
}
.table > thead > tr > th,
.table > tbody > tr > th,
.table > tfoot > tr > th,
.table > thead > tr > td,
.table > tbody > tr > td,
.table > tfoot > tr > td {
  border-bottom: 1px solid #e7eaec !important;
  padding: 5px;
  border: 0px;
}
.table-hover > tbody > tr:hover > td,
.table-hover > tbody > tr:hover > th {
  background-color: #f5f5f5;
}
.no-margins {
  margin: 0 !important;
}
.center {
  width: 100%;
  margin-top: 20px;
  float: left;
}
</style>
