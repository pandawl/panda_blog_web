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
      <el-select v-model="blog.categoryId" placeholder="请选择文章分类">
        <el-option
          :label="category.categoryName"
          :value="category.id"
          v-for="category in categorys"
          :key="category.id"
        ></el-option>
      </el-select>
    </el-form-item>

    <el-form-item label="标签" prop="tags">
      <el-checkbox-group v-model="blog.tags" @change="hehe">
        <el-checkbox :label="tag.id" v-for="tag in checkedItem" :key="tag.id">{{tag.tagName}}</el-checkbox>
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
        <mavon-editor ref="md" @imgAdd="imgAdd" v-model="blog.content" />
      </div>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" native-type="submit">立即创建</el-button>
      <el-button @click="reset()">重置</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
import { saveBlog, getBlog,getImg } from "../../api/blog";
import { getList } from "../../api/category";
import { getTagList } from "../../api/tag";
import axios from "axios";
export default {
  data() {
    return {
      blog: {
        title: "", // 标题
        categoryId: "", //分类
        code: 1, //立即发布
        tags: [], //标签
        summary: "", // 概要
        author: "panda", //
        idDeleted: 0, //
        content: "",
        url: ""
      },
    
      categorys: [],
      checkedItem: [],
      rules: {
        title: [
          { required: true, message: "请输入标题", trigger: "blur" },
          { min: 1, max: 50, message: "长度在 1 到 50 个字符", trigger: "blur" }
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

    imgAdd(pos, file) {
      // 上传图片
     
      var formData = new FormData();
  

     /*  axios
        .post(
          "http://localhost:9999/panda/manage/img/upload", //请求地址
          fileImg
        ) */
        getImg(file).then(url => {
          // console.log(JSON.stringify(url))
          // 第二步.将返回的url替换到文本原位置![...](./0) -> ![...](url)
          /**
           * $vm 指为mavonEditor实例，可以通过如下两种方式获取
           * 1.  通过引入对象获取: `import {mavonEditor} from ...` 等方式引入后，`$vm`为`mavonEditor`
           * 2. 通过$refs获取: html声明ref : `<mavon-editor ref=md ></mavon-editor>，`$vm`为 `this.$refs.md`
           * 3. 由于vue运行访问的路径只能在static下，so，我就把图片保存到它这里了
           */
          this.$refs.md.$img2Url(
            pos,
            "http://localhost:9999/static/image/" + url.imageUrl
          );
        });
    },
    hehe() {
      console.log(this.blog.tags);
    },
    saveBlog() {
      // this.blog.content = this.$refs.md.d_render;

      this.blog.code = this.blog.code === true ? 1 : 0;
      // axios.post("http://www.wangleihh.cn:9999/panda/manage/blog/add",this.blog).then(res => {
      axios
        .post("http://localhost:9999/panda/manage/blog/add", this.blog)
        .then(res => {
          console.log(this.blog);
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
    initData(id) {
      getBlog(id).then(res => {
        this.blog = res.data.resultJson;
        this.blog.code = res.data.resultJson.code === 1 ? true : false;
      });
    }
  },

  components: {},
  created() {
    getList().then(res => {
      this.categorys = res.data.resultJson;
    });

    getTagList().then(res => {
      this.checkedItem = res.data.resultJson;
    });

    let id = this.$route.params.id;
    if (id != null) {
      this.initData(id);
    }
  }
};
</script>
