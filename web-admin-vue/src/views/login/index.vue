<template>
  <div class="login-container">
    <el-form label-position="left" class="login-form" :model="loginForm" :rules="loginRules" auto-complete="on" ref="loginForm">
      <div class="title-container">
        <h3 class="title">panda-blog-admin</h3>
      </div>
      <el-form-item prop="username">
        <span class="svg-container">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-ai-user"></use>
          </svg>
         </span>
        <el-input type="text" v-model="loginForm.username" autoComplete="on" placeholder="username"/>
      </el-form-item>
      <el-form-item prop="password">
        <span class="svg-container">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-mima"></use>
          </svg>
         </span>
        <el-input :type="pwdType" v-model="loginForm.password"  @keyup.enter.native="handleLogin" autoComplete="on" placeholder="password"/>
        <span class="show-pwd" @click="showPwd">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-kejian"></use>
          </svg></span>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" STYLE="width: 100%" :loading="loading" @click.native.prevent="handleLogin">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import {validUsername} from '../../utils/validate'

  export default {
    name: "index",
    data() {
      const validateUsername = (rule, value, callback) => {
        if (!validUsername) {
          callback(new Error('请输入正确的用户名'))
        } else {
          callback()
        }
      }

      const validatePassword = (rule, value, callback) => {
        if (value.len < 6) {
          callback(new Error('密码长度不能小于6位'))
        } else {
          callback()
        }
      }
      return {
        loginForm: {
          username: 'admin',
          password: 'panda'

        },
        loginRules: {
          username: [{required: true, trigger: 'blur', validator: validateUsername}],
          password: [{required: true, trigger: 'blur', validator: validatePassword}]
        },
        pwdType: 'password',
        loading: false
      }
    },
    methods: {
      showPwd(){
        if (this.pwdType == 'password'){
          this.pwdType = ''
        } else{
         this.pwdType = 'password'
        }

      },
      handleLogin(){

        this.$refs.loginForm.validate(valid => {
          if (valid) {

            this.loading = true
            this.$store.dispatch('Login', this.loginForm)
              .then(() => {

                this.$router.push({ path: this.redirect || '/' })
                this.loading = false
              })
              .catch(() => {
                this.loading = false
              })
          } else {
            console.log('error submit!!')
            return false
          }
        })
      }
    }
  }
</script>


<style rel="stylesheet/scss" lang="scss">
  $bg:#2d3a4b;
  $dark_gray:#889aa4;
  $light_gray:#eee;

  .login-container {
    position: fixed;
    height: 100%;
    width:100%;
    background-color: $bg;
    input:-webkit-autofill {
      -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;
      -webkit-text-fill-color: #fff !important;
    }
    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
    }
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;
    }
    .tips {
      font-size: 14px;
      color: #fff;
      margin-bottom: 10px;
    }
    .svg-container {
      padding: 6px 5px 6px 15px;
      color: $dark_gray;
      vertical-align: middle;
      width: 30px;
      display: inline-block;
      &_login {
        font-size: 20px;
      }
    }
    .title {
      font-size: 26px;
      font-weight: 400;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
    .login-form {
      position: absolute;
      left: 0;
      right: 0;
      width: 400px;
      padding: 35px 35px 15px 35px;
      margin: 120px auto;
    }
    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
    .show-pwd {
      position: absolute;
      right: 10px;
      top: 7px;
      font-size: 16px;
      color: $dark_gray;
      cursor: pointer;
      user-select:none;
    }
    .thirdparty-button{
      position: absolute;
      right: 35px;
      bottom: 28px;
    }
  }
</style>
