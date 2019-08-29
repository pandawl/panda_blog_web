<!-- 标签管理 -->
<template>
  <div>
    <!-- 搜索 -->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true"  class="div-background">
        <el-form-item>
          <el-input placeholder="姓名" v-model="searchName"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="selete(searchName)">
            <i class="el-icon-search"></i>搜索
          </el-button>
          <el-button type="primary" @click="reset()">
            <i class="el-icon-search"></i>重置
          </el-button>
        </el-form-item>
        <el-button class="button_left" type="primary" @click="dialogFormVisible = true">新增</el-button>
        <el-dialog title="新增" :visible.sync="dialogFormVisible" width="600px">
          <el-form :model="tag" ref="tagForm">
            <el-form-item label="名称:" :label-width="formLabelWidth">
              <el-input v-model="tag.tagName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="描述:" :label-width="formLabelWidth">
              <el-input v-model="tag.tagDesc" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="addTag('tagForm')">确 定</el-button>
          </div>
        </el-dialog>

        <el-dialog title="修改" :visible.sync="dialogUpdateFormVisible" width="600px">
          <el-form :model="updateTag" ref="tagUpdateForm">
            <el-form-item label="名称:" :label-width="formLabelWidth">
              <el-input v-model="updateTag.tagName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="描述:" :label-width="formLabelWidth">
              <el-input v-model="updateTag.tagDesc" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogUpdateFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="upadateTag()">确 定</el-button>
          </div>
        </el-dialog>
      </el-form>
    </el-col>
    <el-table :data="tableData" style="width: 100%"  class="div-background">
      <el-table-column prop="id" label="id" width="180"></el-table-column>
      <el-table-column prop="tagName" label="名称" width="180"></el-table-column>
      <el-table-column prop="updateTime" label="更新时间"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="upadateTagShow(scope.row.id)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getTagList, add, deleteTag, update, getTagById,getTag } from "../../api/tag";
export default {
  data() {
    return {
      tableData: [],
      searchName: "",
      tag: {
        tagName: "",
        tagDesc: ""
      },
      updateTag: {},
      formLabelWidth: "50px",
      dialogFormVisible: false,
      dialogUpdateFormVisible: false
    };
  },
  inject: ["reload"],
  methods: {
    upadateTagShow(id) {
      //回显
      console.log(id);
      getTagById(id).then(res => {
        this.updateTag = res.data.resultJson;
      });
      this.dialogUpdateFormVisible = true;
    },
    handleDelete(index, row) {
      console.log(row.id);
      deleteTag(row.id).then(res => {
        if (res.data.resultCode == 200) {
          this.$message({
            message: res.data.resultMessage,
            type: "success",
            showClose: true,
            duration: 1000
          });
          this.reload();
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
    addTag(tagForm) {
      add(this.tag).then(res => {
        if (res.data.resultCode == 200) {
          this.dialogFormVisible = false;

          this.$message({
            message: res.data.resultMessage,
            type: "success",
            showClose: true,
            duration: 1000
          });
          this.reload();
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
    upadateTag() {
      update(this.updateTag).then(res => {
        if (res.data.resultCode == 200) {
          this.dialogUpdateFormVisible = false;
          this.$message({
            message: res.data.resultMessage,
            type: "success",
            showClose: true,
            duration: 1000
          });
          this.reload();
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
    selete(tagName) {

      getTag(tagName).then(res => {
        this.tableData = res.data.resultJson;
      });
    },
    reset() {
      getTagList().then(res => {
        this.tableData = res.data.resultJson;
        this.searchName = '';
      });
    }
  },
  mounted() {
    getTagList().then(res => {
      this.tableData = res.data.resultJson;
    });
  },
  watch: {}
};
</script>
<style>
</style>

