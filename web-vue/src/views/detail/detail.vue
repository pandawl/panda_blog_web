<!--  -->
<template>
  <div class="content_box whitebg">
    <h2 class="htitle">
      <span class="con_nav">
        您现在的位置是：
        <a href="/">网站首页</a>>
        <a href="/">{{blog.categoryName}}</a>
      </span>
      {{blog.categoryName}}
    </h2>
    <h1 class="con_tilte">{{blog.title}}</h1>
    <p class="bloginfo">
      <i class="avatar">
        <img src="../../../static/images/wl.jpg" />
      </i>
      <span>panda</span>
      <span>{{blog.createTime}}</span>
      <span>
        【
        <a href="/">{{blog.categoryName}}</a>】
      </span>
      <span>109990人已围观</span>
    </p>
    <p class="con_info">
      <b>简介</b>
      {{blog.summary}}
    </p>
    <div style="overflow:auto" class="con_text">
      <mavon-editor
        class="md"
        :value="blog.content"
        :subfield="false"
        :defaultOpen="'preview'"
        :toolbarsFlag="false"
        :editable="false"
        :scrollStyle="true"
        :ishljs="true"
      ></mavon-editor>
    </div>
    <div class="nextinfo">
      <p>
        上一篇：
        <router-link class="article_link" tag="a" :to="'/blog/detail/'+last.id">{{last.title}}</router-link>
      </p>
      <p>
        下一篇：
        <router-link class="article_link" tag="a" :to="'/blog/detail/'+next.id">{{next.title}}</router-link>
      </p>
    </div>
  </div>
</template>

<script>
import { getBlog } from "../../api/blog";
import marked from "marked";
//import '@/assets/css/markdown/dark.css' //引入代码高亮的css
import hljs from "highlight.js";

//封装成一个指令

export default {
  components: {},
  props: {},
  data() {
    return {
      blog: {},
      last: {},
      next: {}
    };
  },
  computed: {},
  watch: {
    $route(to, from) {
      let id = this.$route.params.id;
      this.initData(id);
    }
  },
  methods: {
    initData(id) {
      getBlog(id).then(res => {
        this.blog = res.data.resultJson;
        this.last = res.data.resultJson.last;
        this.next = res.data.resultJson.next;
        this.blog.content = marked(res.data.resultJson.content);
      });
    }
  },
  created() {},
  mounted() {
    this.blog.blogid = this.$route.params.id;
    getBlog(this.blog.blogid).then(res => {
      this.blog = res.data.resultJson;
      this.last = res.data.resultJson.last;
      this.next = res.data.resultJson.next;

      this.blog.content = marked(res.data.resultJson.content);
    });
  },
  beforeCreate() {}, //生命周期 - 创建之前
  beforeMount() {}, //生命周期 - 挂载之前
  beforeUpdate() {}, //生命周期 - 更新之前
  updated() {}, //生命周期 - 更新之后
  beforeDestroy() {}, //生命周期 - 销毁之前
  destroyed() {}, //生命周期 - 销毁完成
  activated() {} //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css类
.article_link{
  color: #00a67c;
}
.article_link:hover{
  color: #b807cf;
}
</style>