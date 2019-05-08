<template>
  <div class="login-container">
    <el-form label-position="left" class="login-form" :model="loginForm" :rules="loginRules" auto-complete="on">
      <div class="title-container">
        <h3 class="title">panda-blog-admin</h3>
      </div>
      <el-form-item label="用户名" prop="username">
        <span class="svg-container">

        </span>
        <el-input type="text" v-model="loginForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="loginForm.password"></el-input>
      </el-form-item>
      <el-button type="primary">登录</el-button>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "index",
    data() {
      const validateUsername = (rule,value,callback) =>{

      }

      const validatePassword = (rule,value,callback) =>{

      }
      return {
        loginForm: {
          username: 'panda',
          password: 'panda'

        },
        loginRules: {
          username: [{required: true,trigger: 'blur', validator: validateUsername}],
          password: [{required: true,trigger: 'blur', validator: validatePassword}]
        }
      };
    }
  }
</script>

<style scoped>

</style>
