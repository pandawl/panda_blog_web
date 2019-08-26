<template>
  <div>
    <header id="header">
      <div class="navbox">
        <h2 id="mnavh" @click="navOpen" :class="{'open':isOpen}">
          <span class="navicon"></span>
        </h2>
        <div class="logo">
          <router-link to="/">散落记忆里的时光</router-link>
        </div>
        <nav>
          <ul id="starlist" :class="{'navOpen':isOpen}">
            <li>
              <router-link to="/">首页</router-link>
            </li>
            <li>
              <router-link to="/blog/log">Spring Boot</router-link>
            </li>
            <li>
              <router-link to="/blog/about">关于我</router-link>
            </li>

            <!--     <li class="menu">
              <a href="list2.html">博客网站制作</a>
              <ul class="sub">
                <li>
                  <a href="/6">推荐工具</a>
                </li>
                <li>
                  <a href="/7">JS经典实例</a>
                </li>
                <li>
                  <a href="/8">网站建设</a>
                </li>
                <li>
                  <a href="/7">CSS3|Html5</a>
                </li>
                <li>
                  <a href="/8">心得笔记</a>
                </li>
              </ul>
              <span></span>
            </li>-->
            <!--         <li>
              <a href="list3.html">网页设计心得</a>
            </li>
            <li>
              <a href="daohang.html">优秀个人博客</a>
            </li>
            <li>
              <a href="about.html">关于我</a>
            </li>-->
          </ul>
        </nav>
        <div class="searchico" @click="searchopen()"></div>
      </div>
    </header>
    <div class="searchbox">
      <div class="search" :class="{'open':isChoose}">
        <div>
          <el-input placeholder="请输入内容" v-model="search" class="input-with-select">
            <el-button slot="append" icon="el-icon-search" @click="searchBlog()"></el-button>
          </el-input>
        </div>
      </div>
      <div class="searchclose" @click="searchclose()"></div>
    </div>
  </div>
</template>
<script>
export default {
  name: "HeaderMenus",
  data() {
    return {
      isChoose: false,
      isOpen: false,
      search: ""
    };
  },
    watch: {
    $route(to, from) {
         this.search = "";
      this.isChoose = false;
    },
  },
  methods: {
    searchBlog() {
      if (this.search == "" || null == this.search) {
        this.$message({
          showClose: true,
          message: "请输入查询内容",
          type: "warning"
        });
      } else {
        this.$router.push({
          path: "/blog/search",
          query: { name: this.search }
        });
    
      }
    },
    searchopen() {
      this.isChoose = !this.isChoose;
    },
    searchclose() {
      this.search = "";
      this.isChoose = false;
    },
    navOpen() {
      this.isOpen = !this.isOpen;
    }
  }
};
</script>

<style scoped>
.search {
  width: 50%;
  margin: 20px auto;
  position: relative;
  display: none;
}
.navOpen {
  display: block !important;
}
</style>
