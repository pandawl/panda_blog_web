<template>
  <div class="app-container">
    <el-form :model="blog" :rules="rules" ref="blog" label-width="100px" class="demo-blog">
      <el-form-item label="标题" prop="title">
        <el-input v-model="blog.title"></el-input>
      </el-form-item>
      <el-form-item label="分类" prop="categoryId">
        <el-select v-model="blog.categoryId" placeholder="请选择文章分类">
          <el-option label="技术" value="1"></el-option>
          <el-option label="生活笔记" value="2"></el-option>
          <el-option label="其他" value="3"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="标签" prop="tags">
        <el-checkbox-group v-model="blog.tags">
          <el-checkbox label="5">Java</el-checkbox>
          <el-checkbox label="4" value="4">MySQL</el-checkbox>
          <el-checkbox label="7" value="7">设计模式</el-checkbox>
          <el-checkbox label="6" value="6">算法</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="立即发布" prop="code">
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
        <el-button type="primary" @click="submitForm()">立即创建</el-button>
        <el-button @click="resetForm('blog')">重置</el-button>
      </el-form-item>
    </el-form>


  </div>
</template>

<script>
  import 'quill/dist/quill.core.css'
  import 'quill/dist/quill.snow.css'
  import 'quill/dist/quill.bubble.css'
  import {quillEditor} from 'vue-quill-editor'
  import axios from 'Axios'

  export default {
    name: 'editor',
    id: null,
    data: function () {
      return {
        blog: {
          title: '',
          categoryId: '',
          code: 1,
          tags: [],
          summary: '',
          author: 'Jann',
          isDeleted: 0
        },
        rules: {
          title: [
            {required: true, message: '请输入标题', trigger: 'blur'},
            {min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur'}
          ],
          categoryId: [
            {required: true, message: '请选择分类', trigger: 'change'}
          ],
          date1: [
            {type: 'date', required: true, message: '请选择日期', trigger: 'change'}
          ],
          date2: [
            {type: 'date', required: true, message: '请选择时间', trigger: 'change'}
          ],
          tags: [
            {type: 'array', required: true, message: '请至少选择一个标签', trigger: 'change'}
          ],
          resource: [
            {required: true, message: '123', trigger: 'change'}
          ],
          summary: [
            {required: true, message: '请填写文章摘要', trigger: 'blur'}
          ]
        },
        content: '',
        editorOption: {
          placeholder: 'Hello World'
        }
      }
    },
    components: {
      quillEditor
    },
    created() {
      this.getParams()
    },
    mounted() {
      this.initData(this.id)
    },
    methods: {
      initData(id) {
        if (id !== null) {
          axios.get('http://123.206.88.191:8088/manage/blogs/' + id).then(result => {
            if (result.data.status === 1000) {
              this.blog = result.data.data
              console.log(this.blog)
            } else {
              this.$message.error(JSON.stringify(result.data.msg))
            }
          })
        }
      },
      getParams() {
        // 取到路由带过来的参数
        const routerParams = this.$route.query.id
        // 将数据放在当前组件的数据内
        this.id = routerParams
        this.keyupMallName()
      },
      onEditorChange({editor, html, text}) {
        this.content = html
      },
      submitForm() {
        this.blog.code = this.blog.code === true ? 0 : 1
        alert(JSON.stringify(this.blog))
        axios.post('http://123.206.88.191:8088/manage/blogs', this.blog).then(result => {
          if (result.data.status === 1000) {
            this.$message.success('提交成功！')
          } else {
            this.$message.error(JSON.stringify(result.data.msg))
          }
        })
      }
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss" scoped>
  .editor-btn {
    margin-top: 20px;
  }

  .crumbs, .plugins-tips {
    margin-bottom: 20px
  }

  .container {
    padding: 30px;
    background: #fff;
    border: 1px solid #ddd;
    border-radius: 5px
  }

  .markdown-body {
    height: 440px;
  }
</style>
