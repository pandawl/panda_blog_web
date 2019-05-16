<!--  -->
<template>
  <el-form @submit.native.prevent="saveBlog" ref="blog" :model="blog" label-width="120px">
    <el-form-item label="文章标题">
      <el-input v-model="blog.title"></el-input>
    </el-form-item>

    <el-form-item label="文章内容">
      <el-input type="textarea" v-model="blog.content"></el-input>
    </el-form-item>
    <el-form-item >
      <div class="edit_container">
        <quill-editor
          v-model="blog.content"
          ref="myQuillEditor"
          :options="editorOption"
          @blur="onEditorBlur($event)"
          @focus="onEditorFocus($event)"
          @change="onEditorChange($event)"
        ></quill-editor>
      </div>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" native-type="submit">立即创建</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
import { saveBlog } from "../../api/blog";
import { quillEditor } from "vue-quill-editor"; //调用编辑器
import "quill/dist/quill.core.css";
import "quill/dist/quill.snow.css";
import "quill/dist/quill.bubble.css";

export default {
  data() {
    return {
      blog: {}
    };
  },
  methods: {
    saveBlog() {
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
    onEditorReady(editor) { // 准备编辑器
 
        }
  },
  components: {
    quillEditor
  }
};
</script>
