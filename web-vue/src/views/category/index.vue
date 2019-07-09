<template>
  <div class="head_aricle">
    <div>
      <div class="whitebg bloglist left">
        <h2 class="htitle">{{categoryName}}</h2>
        <ul v-show="article">
          <!--单图-->
          <li v-for="blog in blogs" :key="blog.id" :blogDetail="blog">
            <h3 class="blogtitle">
              <router-link :to="`/blog/detail/${blog.id}`">{{blog.title}}</router-link>
            </h3>
            <span class="blogpic imgscale">
              <i>
                <a href="/">{{blog.categoryName}}</a>
              </i>
              <a href="/" title>
                <img src="../../../static/images/b02.jpg" :alt="blog.title" />
              </a>
            </span>
            <p class="blogtext">{{blog.summary}}...</p>
            <p class="bloginfo">
              <i class="avatar">
                <img src="../../../static/images/wl.jpg" />
              </i>
              <span>散落记忆里的时光</span>
              <span>{{blog.createTime}}</span>
              <span>
                【
                <a href="/">{{blog.categoryName}}</a>】
              </span>
            </p>
            <a href="/" class="viewmore">阅读更多</a>
          </li>
        </ul>
        <h2 v-show="!article" style="text-align: center;">该分类下暂无文章~~~</h2>
        <!--pagelist-->
        <Pager
          v-if="!dataChanged"
          ref="pager"
          :pageSize="pageSize"
          :curPage="curPage"
          :total="total"
          @setPage="gotoPage"
          @setRowNum="changeRowNum"
        v-show="article"/>
      </div>
    </div>
    <Rbox />
  </div>
</template>

<script>
import Rbox from "../../components/rbox/Rbox";
import { getBlogByCategory,getCategory } from "../../api/blog";
import Pager from "../../components/Pager";
export default {
  name: "",

  components: { Pager, Rbox },
  props: {},
  data() {
    return {
      id: 0,
      blogs: [],
      blogDetail: {},
      curPage: 1, //当前页
      total: 0, //总共页数
      pageSize: 10, //每页记录数
      dataChanged: false,
      article: true,
      categoryName: ""
    };
  },
  mounted() {
   let id = this.$route.params.id;
      getBlogByCategory(this.curPage, this.pageSize,id).then(res => {
        this.blogs = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
      getCategory(id).then(res=>{
        this.categoryName= res.data.resultJson.categoryName
      })
  },
  watch: {
    $route(to, from) {
      let id = this.$route.params.id;
      console.log("开始加载数据")
      this.initData(id);
    },
   blogs:{handler(){
     console.log(this.article)
     this.article = this.blogs.length >0  ?true :false
   }} 
  },
  methods: {
    refresh() {
      //用于刷新组件，需手动调用
      this.dataChanged = true;
      this.$nextTick(() => {
        this.dataChanged = false;
      });
    },
    initData(id) {
      getBlogByCategory(this.curPage, this.pageSize,id).then(res => {
        this.blogs = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
      getCategory(id).then(res=>{
        this.categoryName= res.data.resultJson.categoryName
      })
    },

    gotoPage(curPage) {
      let id = this.$route.params.id;
      getBlogByCategory(curPage, this.pageSize,id).then(res => {
        this.blogs = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
    },
    changeRowNum(pageSize) {
      this.pageSize = pageSize;
      let id = this.$route.params.id;
      getBlogByCategory(this.curPage, this.pageSize,id).then(res => {
        this.blogs = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
    }
  }
};
</script>
 
<style scoped>
.left {
  float: left;
  width: 71.5%;
}
.head_aricle {
  width: 80%;

  margin: auto;
  margin-top: 10px;
  overflow: hidden;
}
</style>
