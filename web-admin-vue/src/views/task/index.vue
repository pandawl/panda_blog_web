<template>
  <div>
    <!-- 搜索 -->
    <div class="div-background search">
      <el-col :span="30" class="toolbar" style="padding-bottom: 0px;">
        <el-form :inline="true" class>
          <el-form-item>
            <el-select v-model="value" clearable placeholder="状态">
              <el-option
                v-for="item in status"
                :key="item.statusId"
                :label="item.label"
                :value="item.statusId"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-input placeholder="任务名称" v-model="searchName"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="search(value,searchName)">
              <i class="el-icon-search"></i>搜索
            </el-button>
            <el-button type="primary" @click="reset()">
              <i class="el-icon-search"></i>重置
            </el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </div>
    <!-- 列表 -->
    <div class="div-background task-table">
      <el-button size="small" type="primary">
        <i class="iconfont">&#xe608;</i>新增
      </el-button>
      <el-button size="small" type="success">
        <i class="iconfont">&#xe6a1;</i>一键开启
      </el-button>
      <el-button size="small" type="danger">
        <i class="iconfont">&#xe617;</i>一键关闭
      </el-button>

      <el-table :data="tableList" class="elTable" style="width: 100%;">
        <el-table-column fixed prop="jobName" label="任务名称" :show-overflow-tooltip="true"></el-table-column>
        <el-table-column prop="cronExpression" label="时间表达式" :show-overflow-tooltip="true"></el-table-column>
        <el-table-column prop="beanClass" label="执行类" width="300px" :show-overflow-tooltip="true"></el-table-column>
        <el-table-column align="center" :formatter="formatCode" label="状态"></el-table-column>
        <el-table-column fixed="right" label="操作 " width="300px">
          <template slot-scope="scope">
            <div v-if="scope.row.jobStatus == 1">
              <el-button size="small" type="warning" @click="handleStop(scope.row.id)">
                <i class="iconfont">&#xe65a;</i>关闭
              </el-button>
            </div>
            <div v-else>
              <el-button
                size="small"
                style="background-color:#1ab394;border-color: #1ab394; color: #FFFFFF;"
                @click="handleUpdate(scope.row.id)"
              >
                <i class="iconfont">&#xe7ad;</i>编辑
              </el-button>
              <el-button size="small" type="primary" @click="handleStart(scope.row.id)">
                <i class="iconfont">&#xe7ec;</i>启动
              </el-button>
              <el-button size="small" type="danger" @click="handleDelete(scope.row.id)">
                <i class="iconfont">&#xe612;</i>删除
              </el-button>
            </div>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <Pager
      v-if="!dataChanged"
      ref="pager"
      :pageSize="pageSize"
      :curPage="curPage"
      :total="total"
      @setPage="gotoPage"
      @setRowNum="changeRowNum"
    />
  </div>
</template>

<script>
import { getTask,startTask,stopTask } from "../../api/task";
import Pager from "../../components/Pager";
export default {
  name: "",

  components: { Pager },

  created() {
    this.getBlog();
  },
  data() {
    return {
      value: "",
      searchName: "",
      tableList: [],
      curPage: 1, //当前页
      total: 0, //总共页数
      pageSize: 10, //每页记录数
      dataChanged: false,
      status: [
        {
          statusId: 0,
          label: "未启动"
        },
        {
          statusId: 1,
          label: "启动"
        },

        {
          statusId: 2,
          label: "停止"
        }
      ]
    };
  },
  methods: {
    handleUpdate(id) {
      this.$router.push("/blog/edit/" + id);
    },
    add() {
      this.$router.push("/blog/edit/");
    },
    reset() {
      this.getBlog();
      this.value = "";
      this.searchName = "";
    },
    search(value, searchName) {
      getTask(this.curPage, this.pageSize, value, searchName).then(res => {
        if (res.data.resultCode == 200) {
          this.tableList = res.data.resultJson.list;
          this.curPage = res.data.resultJson.pageNum;
          this.total = res.data.resultJson.pages;
          this.pageSize = res.data.resultJson.pageSize;
        }
        this.refresh();
      });
    },
    refresh() {
      //用于刷新组件，需手动调用
      this.dataChanged = true;
      this.$nextTick(() => {
        this.dataChanged = false;
      });
    },
    deleteUpdate(id) {},
    formatCode: function(row, colum) {
      return row.jobStatus == 0
        ? "未启动"
        : row.jobStatus == 1
        ? "启动"
        : row.jobStatus == 2
        ? "停止"
        : "未知";
    },
    doFilter() {},
    getBlog() {
      getTask(this.curPage, this.pageSize).then(res => {
        if (res.data.resultCode == 200) {
          this.tableList = res.data.resultJson.list;
          this.curPage = res.data.resultJson.pageNum;
          this.total = res.data.resultJson.pages;
          this.pageSize = res.data.resultJson.pageSize;
        }
        this.refresh();
      });
    },
    handleStop(id) {
      stopTask({ id }).then(res => {
        if (res.data.resultCode == 200) {
          this.$message({
            message: res.data.resultMessage || "停止成功",
            type: "success",
            showClose: true,
            duration: 1000
          });
          this.getBlog();
        } else {
          this.$message({
            message: res.data.resultMessage || "停止失败",
            type: "error",
            showClose: true,
            duration: 1000
          });
        }
      });
    },
    handleStart(id) {
      startTask({ id }).then(res => {
        if (res.data.resultCode == 200) {
          this.$message({
            message: res.data.resultMessage || "启动成功",
            type: "success",
            showClose: true,
            duration: 1000
          });
          this.getBlog();
        } else {
          this.$message({
            message: res.data.resultMessage || "启动失败",
            type: "error",
            showClose: true,
            duration: 1000
          });
        }
      });
    },
    handleDelete(id) {
      deleteBlogById({ id }).then(res => {
        if (res.data.resultCode == 200) {
          this.$message({
            message: res.data.resultMessage || "删除成功",
            type: "success",
            showClose: true,
            duration: 1000
          });
          this.getBlog();
        } else {
          this.$message({
            message: res.data.resultMessage || "删除失败，请联系管理员",
            type: "error",
            showClose: true,
            duration: 1000
          });
        }
      });
    },
    gotoPage(curPage) {
      getTask(curPage, this.pageSize).then(res => {
        this.tableList = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
    },
    changeRowNum(pageSize) {
      this.pageSize = pageSize;
      getTask(this.curPage, this.pageSize).then(res => {
        this.tableList = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
    }
  }
};
</script>

<style scoped>
.search {
  height: 50px;
}
</style>
