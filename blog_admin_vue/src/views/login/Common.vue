<template>
  <div class="container">
    <div class="content">
      <div class="top">
        <div class="header">
          <div class="author"></div>
          <span class="title">{{systemName}}</span>
        </div>
        <div class="desc"></div>
      </div>
      <component :is="componentName" @regist="handleRegist" class="main-content"></component>
    </div>
    <global-footer :copyright="copyright" />
  </div>
</template>

<script>
import GlobalFooter from '../common/GlobalFooter'
import Login from './Login'
import Regist from './Regist'

export default {
  name: 'Common',
  components: {GlobalFooter, Login, Regist},
  data () {
    return {
      componentName: 'Login'
    }
  },
  computed: {
    systemName () {
      return this.$store.state.setting.systemName
    },
    copyright () {
      return this.$store.state.setting.copyright
    }
  },
  methods: {
    handleRegist (val) {
      this.componentName = val
    }
  }
}
</script>

<style lang="less" scoped>
  .container {
    display: flex;
    flex-direction: column;
    height: 100vh;
    overflow: auto;
    background: #f0f2f5 url('http://img.wangleihh.cn/blog/web/static/img/TVYTbAXWheQpRcWDaDMu.svg') no-repeat center 110px;
    background-size: 100%;
    .content {
      padding: 32px 0;
      flex: 1;
      @media (min-width: 768px) {
        padding: 116px 0 10px;
      }
      .top {
        text-align: center;
        .header {
          height: 50px;
          line-height: 50px;
          a {
            text-decoration: none;
          }
          .author{
            position: absolute;
            top: 1em;
            left: 51em;
            margin: 0 0 1.5em;
          }
          .author:hover {
            -webkit-transform: rotateZ(360deg);
            -moz-transform: rotateZ(360deg);
            -o-transform: rotateZ(360deg);
            -ms-transform: rotateZ(360deg);
            transform: rotateZ(360deg);
          }
          .author{
            width: 6.875em;
            height: 6.875em;
            margin: 0 auto;
            background: no-repeat url(http://img.wangleihh.cn/blog/web/static/images/111.jpg) left top;
            -webkit-background-size: 6.875em 6.875em;
            -moz-background-size: 6.875em 6.875em;
            background-size: 6.875em 6.875em;
            border-radius: 3.4375em;
            -webkit-transition: -webkit-transform 2s ease-out;
            -moz-transition: -moz-transform 2s ease-out;
            -o-transition: -o-transform 2s ease-out;
            -ms-transition: -ms-transform 2s ease-out;
            transition: transform 2s ease-out;
          }
          .title {
            font-size: 28px;
            color: rgba(0, 0, 0, .85);
            font-family: 'Myriad Pro', 'Helvetica Neue', Arial, Helvetica, sans-serif;
            font-weight: 600;
            position: relative;
            top: 6px;
          }
        }
        .desc {
          font-size: 14px;
          color: rgba(0, 0, 0, .45);
          margin-top: 12px;
          margin-bottom: 40px;
        }
      }
      .main-content {
        width: 368px;
        margin: 0 auto;
        @media screen and (max-width: 576px) {
          width: 95%;
        }
        @media screen and (max-width: 320px) {
          .captcha-button {
            font-size: 14px;
          }
        }
      }
    }
  }

</style>
