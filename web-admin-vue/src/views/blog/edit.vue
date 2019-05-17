<!--  -->
<template>
  <el-form
    @submit.native.prevent="saveBlog"
    ref="blog"
    :rules="rules"
    :model="blog"
    label-width="120px"
  >
    <el-form-item label="标题" prop="title">
      <el-input v-model="blog.title"></el-input>
    </el-form-item>

    <el-form-item label="分类" prop="categoryId">
      <el-select v-model="blog.categoryId" placeholder="请选择文章分类" >
        <el-option :label="category.category_name" :value="category.id" v-for="category in categorys" :key="category.id"></el-option>
      </el-select>
    </el-form-item>

    <el-form-item label="标签" prop="tags">
      <el-checkbox-group v-model="checkedItem">
        <el-checkbox :label="tag.id"   v-for="tag in blog.tags" :key="tag.id" @change="chooseItem(tag.id)">{{tag.tag_name}}</el-checkbox>
      </el-checkbox-group>
    </el-form-item>

    <el-form-item label="立即发布">
      <el-switch v-model="blog.code"></el-switch>
    </el-form-item>
    <el-form-item label="概要" prop="summary">
      <el-input type="textarea" v-model="blog.summary"></el-input>
    </el-form-item>

    <el-form-item>
      <div id="main">
        <mavon-editor ref="md" v-model="blog.content"/>
      </div>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" native-type="submit">立即创建</el-button>
      <el-button @click="reset()">重置</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
import { saveBlog } from "../../api/blog";
import { getList } from "../../api/category";
import { getTagList } from "../../api/tag";
export default {
  data() {
    return {
      blog: {
        title: "", // 标题
        categoryId: "", //分类
        code: 1, //立即发布
        tags: [], //标签
        summarys: "", // 概要
        author: "panda", //
        idDeleted: 0, //
        content: ""
      },
      categorys: [],
      checkedItem: [],
      rules: {
        title: [
          { required: true, message: "请输入标题", trigger: "blur" },
          { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
        ],
        categoryId: [
          { required: true, message: "请选择分类", trigger: "change" }
        ],
        date1: [
          {
            type: "date",
            required: true,
            message: "请选择日期",
            trigger: "change"
          }
        ],
        date2: [
          {
            type: "date",
            required: true,
            message: "请选择时间",
            trigger: "change"
          }
        ],
        tags: [
          {
            type: "array",
            required: true,
            message: "请至少选择一个标签",
            trigger: "change"
          }
        ],
        summary: [
          { required: true, message: "请填写文章摘要", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
     chooseItem(){

     },
    saveBlog() {
      this.blog.code = this.blog.code === true ? 0 : 1;
      saveBlog(this.blog).then(res => {
        if (res.data.resultCode == 200) {
          this.$message({
            message: res.data.resultMessage,
            type: "success",
            showClose: true,
            duration: 1000
          });
          this.$router.push("/blog/list");
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
    reset() {}
  },
  components: {},
  created() {
    getList().then(res => {
      this.categorys = res.data.resultJson;
    });

      getTagList().then(res => {
      this.blog.tags = res.data.resultJson;
    
    });
  }
};
</script>
