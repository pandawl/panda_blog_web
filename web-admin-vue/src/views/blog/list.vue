<template>
  <div>
    <!-- 搜索 -->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true">
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
          <el-input placeholder="姓名" v-model="searchName"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="doFilter()">
            <i class="el-icon-search"></i>搜索
          </el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>
    <!-- 列表 -->
    <el-table :data="tableList" style="width: 100%;">
      <el-table-column prop="id" label="序号" width="65"></el-table-column>
      <el-table-column prop="title" label="标题"></el-table-column>
      <el-table-column prop="summary" min-width="150px" label="标题"></el-table-column>
      <el-table-column prop="viewCount" label="阅读数" width="65"></el-table-column>
      <el-table-column prop="updateTime" label="修改时间" width="160px"></el-table-column>
      <el-table-column :formatter="formatCode" label="状态" width="120"></el-table-column>
      <el-table-column prop="operation" label="操作 ">
        <template slot-scope="scope">
          <el-button size="small" type="primary" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button size="small" type="danger" @click="deleteUpdate(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
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
import { getBlogs, deleteBlogById } from "../../api/blog";
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
          statusId: 1,
          label: "启用"
        },
        {
          statusId: 2,
          label: "禁用"
        }
      ]
    };
  },
  methods: {
    handleUpdate() {},
    refresh() {
      //用于刷新组件，需手动调用
      this.dataChanged = true;
      this.$nextTick(() => {
        this.dataChanged = false;
      });
    },
    deleteUpdate() {},
    formatCode: function(row, colum) {
      return row.code === 0
        ? "已发布"
        : row.code === 1
        ? "删除"
        : row.code === 2
        ? "草稿"
        : "未知";
    },
    doFilter() {},
    getBlog() {
      getBlogs(this.curPage, this.pageSize).then(res => {
        if (res.data.resultCode == 200) {
          this.tableList = res.data.resultJson.list;
          this.curPage = res.data.resultJson.pageNum;
          this.total = res.data.resultJson.pages;
          this.pageSize = res.data.resultJson.pageSize;
        }
        this.refresh();
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
          this.getBlogs();
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
      getBlogs(curPage, this.pageSize).then(res => {
        this.tableList = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
    },
    changeRowNum(pageSize) {
      this.pageSize = pageSize;
       getBlogs(this.curPage, this.pageSize).then(res => {
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
</style>